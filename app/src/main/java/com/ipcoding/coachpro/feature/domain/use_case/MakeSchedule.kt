package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.model.Match
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository

class MakeSchedule(
    private val clubRepository: ClubRepository,
    private val matchRepository: MatchRepository
) {

    suspend operator fun invoke(league: String) {

        val tempClubList: List<Club> = clubRepository.getClubsFromLeagueByPosition(league)

        if(tempClubList.isNotEmpty()) {
            val numTeams = tempClubList.size

            // Days needed to complete tournament
            val numDays = numTeams - 1

            val halfSize = numTeams / 2

            // Add teams to List and remove the first team
            val teams: MutableList<Club> = mutableListOf()

            teams.addAll(tempClubList)

            teams.removeAt(0)

            val teamsSize = teams.size

            for (day in 0 until numDays) {
                var round1: Int
                var round2: Int
                val teamIdx = day % teamsSize
                if (day % 2 == 0) {
                    round1 = day + 1
                    round2 = day + 1 + 19
                } else {
                    round2 = day + 1
                    round1 = day + 1 + 19
                }
                matchRepository.insertMatch(
                    Match( round1, teams[teamIdx].name,
                        tempClubList[0].name, -1, -1)
                )
                matchRepository.insertMatch(
                    Match( round2, tempClubList[0].name, teams[teamIdx].name,
                        -1, -1)
                )
                for (idx in 1 until halfSize) {
                    val firstTeam = (day + idx) % teamsSize
                    val secondTeam = (day + teamsSize - idx) % teamsSize
                    matchRepository.insertMatch(
                        Match( round1, teams[firstTeam].name, teams[secondTeam].name,
                            -1, -1)
                    )
                    matchRepository.insertMatch(
                        Match(round2, teams[secondTeam].name, teams[firstTeam].name,
                            -1, -1)
                    )
                }
            }
        }
    }
}