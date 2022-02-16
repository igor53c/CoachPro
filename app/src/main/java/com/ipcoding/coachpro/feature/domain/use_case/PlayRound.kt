package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository
import kotlin.math.ceil
import kotlin.random.Random

class PlayRound(
    private val matchRepository: MatchRepository,
    private val clubRepository: ClubRepository,
    private val playerRepository: PlayerRepository,
    private val preferences: Preferences
) {

    suspend operator fun invoke(round: Int) {

        val matchList = matchRepository.getMatchesFromRound(round)

        matchList.forEach { match ->
            val host = clubRepository.getClub(match.host)
            val guest = clubRepository.getClub(match.guest)
            val clubName = preferences.loadClubName()
            val ratingDifference = guest?.rating?.let { host?.rating?.minus(it) }

            if (ratingDifference != null) {
                match.goalsHost = numberGoals(ratingDifference + 2)
                match.goalsGuest = numberGoals(- ratingDifference - 2)

                if(host?.name == clubName)
                    changePlayerRatingBasedOnResult(match.goalsHost, match.goalsGuest)

                if(guest.name == clubName)
                    changePlayerRatingBasedOnResult(match.goalsGuest, match.goalsHost)
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
            GetStringLeague()(it)
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

    private suspend fun changePlayerRatingBasedOnResult(goalsFor: Int, goalsAgainst: Int) {

        val players: List<Player> = playerRepository.getPlayers()

        for (i in 0..10) {

            when {
                goalsFor > goalsAgainst -> {
                    players[i].rating += 0.15
                    players[i].motivation += 20
                    if (players[i].motivation > 100) players[i].motivation = 100
                }
                goalsFor == goalsAgainst -> {
                    players[i].rating += 0.10
                }
                goalsFor < goalsAgainst -> {
                    players[i].rating += 0.05
                    players[i].motivation -= 20
                    if (players[i].motivation < 0) players[i].motivation = 0
                }
            }
            if (players[i].rating > 99) players[i].rating = 99.0

            players[i].fitness -= 20
            if (players[i].fitness < 0) players[i].fitness = 0
            playerRepository.insertPlayer(players[i])
        }
        for (i in 11 until players.size) {
            players[i].motivation += 20
            if (players[i].motivation > 100) players[i].motivation = 100
            playerRepository.insertPlayer(players[i])
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
    val max0 = 30 - (ratingDifference * 2.5).toInt()
    val max1 = max0 + 32 - (ratingDifference / 2.5).toInt()
    val max2 = max1 + 21 + (ratingDifference / 1.5).toInt()
    val max = 100 - max2

    when {
        number < max0 -> return 0
        number < max1 -> return 1
        number < max2 -> return 2
        else -> {
            val max3 = max2 + ceil(max / 2.0)
            val max4 = max3 + ceil(max / 4.0)
            val max5 = max4 + ceil(max / 8.0)
            val max6 = max5 + ceil(max / 16.0)
            val max7 = max6 + ceil(max / 32.0)
            return when {
                number < max3 -> 3
                number < max4 -> 4
                number < max5 -> 5
                number < max6 -> 6
                number < max7 -> 7
                else -> 8
            }
        }
    }
}