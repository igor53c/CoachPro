package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.repository.ClubRepository
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository

class PreparationOfClubsAndScheduling(
    private val clubRepository: ClubRepository,
    private val matchRepository: MatchRepository
) {

    suspend fun invoke(league: String) {

        val leagueList: MutableList<String> = mutableListOf()
        leagueList[0] = league
        var rating = 95.0
        for (i in 1..7) {
            val currentLeague = i.toString()
            if (leagueList[0] != currentLeague) {
                val clubs = clubRepository.getClubsFromLeagueByRating(currentLeague)
                var position = 0
                for (club in clubs) {
                    position++
                    club.position = position
                    club.rating = rating
                    clubRepository.insertClub(club)
                    rating = rating - 0.5
                }
            } else {
                rating = rating - 10.0
            }
        }
        matchRepository.deleteAll()
        val clubs = clubRepository.getClubsFromLeague(leagueList[0])
        for (club in clubs) {
            club.apply {
                win = 0
                draw = 0
                lose = 0
                goalsFor = 0
                goalsAgainst = 0
                goalDifference = 0
                points = 0
            }
            clubRepository.insertClub(club)
        }
        MakeSchedule(clubRepository, matchRepository).invoke(leagueList.get(0))
    }
}