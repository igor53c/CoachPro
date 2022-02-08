package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository
import kotlin.random.Random

class PlayRound(
    private val matchRepository: MatchRepository,
    private val clubRepository: ClubRepository,
    private val preferences: Preferences
) {

    suspend operator fun invoke(round: Int) {

        val matchList = matchRepository.getMatchesFromRound(round)

        matchList.forEach { match ->
            val host = clubRepository.getClub(match.host)
            val guest = clubRepository.getClub(match.guest)
            val ratingDifference = guest?.rating?.let { host?.rating?.minus(it) }

            if (ratingDifference != null) {
                match.goalsHost = numberGoals(ratingDifference + 2)
                match.goalsGuest = numberGoals(- ratingDifference - 2)
            }
            matchRepository.insertMatch(match)
            changeClubDetails(host, match.goalsHost, match.goalsGuest)?.let {
                clubRepository.insertClub(it)
            }
            changeClubDetails(guest, match.goalsGuest, match.goalsHost)?.let {
                clubRepository.insertClub(it)
            }
        }

        // set the positions of the clubs on the table
        val clubList = preferences.loadSelectedLeague()?.let {
            GetStringLeague().invoke(it)
        }?.let {
            clubRepository.getClubsFromLeague(it)
        }

        clubList?.let {
            for (i in clubList.indices) {

                clubList[i].position = i + 1

                clubRepository.insertClub(clubList[i])
            }
        }
    }
}

fun changeClubDetails(club: Club?, goalsFor: Int, goalsAgainst: Int): Club? {
     club?.let {
        club.goalsFor += goalsFor
        club.goalsAgainst += goalsAgainst
        club.goalDifference += goalsFor - goalsAgainst
        when {
            goalsFor < goalsAgainst -> club.lose += 1
            goalsFor == goalsAgainst -> {
                club.draw += 1
                club.points += 1
            }
            goalsFor > goalsAgainst -> {
                club.win += 1
                club.points += 3
            }
        }
    }
    return club
}

fun numberGoals(ratingDifference: Double): Int {
    val number = Random.nextInt(100)
    val max0 = 26 - ratingDifference.toInt()
    val max1 = max0 + 36 - (ratingDifference / 2.5).toInt()
    val max2 = max1 + 24 + (ratingDifference / 1.5).toInt()
    val max = 100 - max2

    when {
        number < max0 -> return 0
        number < max1 -> return 1
        number < max2 -> return 2
        else -> {
            val number2 = Random.nextInt(max)
            val max3 = max / 2
            val max4 = max3 + max3 / 2
            val max5 = max4 + (max - max4) / 2
            val max6 = max5 + (max - max5) / 2
            val max7 = max6 + (max - max6) / 2
            return when {
                number2 < max3 -> 3
                number2 < max4 -> 4
                number2 < max5 -> 5
                number2 < max6 -> 6
                number2 < max7 -> 7
                else -> 8
            }
        }
    }
}