package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository

class PreparingForNewSeason(
    private val clubRepository: ClubRepository,
    private val preferences: Preferences
) {
    private var clubList = emptyList<Club>()
    private var club = ""
    private var league = 0

    suspend operator fun invoke(clubName: String, leagueNumber: Int) {
            club = clubName
            league = leagueNumber
            clubList = clubRepository.getClubsFromLeague("League $league")
            when (league) {
                1 -> organizeLeagues(hasLowerLeague = true,  hasMajorLeague = false)
                2 -> organizeLeagues(hasLowerLeague = true,  hasMajorLeague = true)
                3 -> organizeLeagues(hasLowerLeague = true,  hasMajorLeague = true)
                4 -> organizeLeagues(hasLowerLeague = true,  hasMajorLeague = true)
                5 -> organizeLeagues(hasLowerLeague = true,  hasMajorLeague = true)
                6 -> organizeLeagues(hasLowerLeague = true,  hasMajorLeague = true)
                7 -> organizeLeagues(hasLowerLeague = false,  hasMajorLeague = true)
                else -> {}
            }
    }

    private suspend fun organizeLeagues(hasLowerLeague: Boolean,  hasMajorLeague: Boolean) {
        for (i in 0..19) {
            when(i) {
                in 0..3 -> if(hasMajorLeague) majorLeague(i) else resetCurrentClub(i)
                in 4..15 -> resetCurrentClub(i)
                in 16..19 -> if(hasLowerLeague) lowerLeague(i) else resetCurrentClub(i)
            }
        }
    }

    private suspend fun resetCurrentClub(i: Int) {
        val currentClub =
            resetClubInfo(clubList[i], league.toString(), i + 1)
        clubRepository.insertClub(currentClub)
    }

    private suspend fun majorLeague(i: Int) {
        val leagueString = (league - 1).toString()
        val clubListMajorLeague: List<Club> =
            clubRepository.getClubsFromLeagueByPosition("League $leagueString")
        val nextClub = clubListMajorLeague[16 + i]
        if (club == clubList[i].name) preferences.saveSelectedLeague(leagueString)
        val currentClub = resetClubInfo( clubList[i], leagueString, 17 + i)
        clubRepository.insertClub(currentClub)
        nextClub.league = "League $league"
        nextClub.position = i + 1
        clubRepository.insertClub(nextClub)
    }

    private suspend fun lowerLeague(i: Int) {
        val leagueString = (league + 1).toString()
        val clubListLowerLeague: List<Club> =
            clubRepository.getClubsFromLeagueByPosition("League $leagueString")
        val nextClub = clubListLowerLeague[i - 16]
        if (club == clubList[i].name) preferences.saveSelectedLeague(leagueString)
        val currentClub = resetClubInfo(clubList[i], leagueString, i - 15)
        clubRepository.insertClub(currentClub)
        nextClub.league = "League $league"
        nextClub.position = i + 1
        clubRepository.insertClub(nextClub)
    }
}



private fun resetClubInfo(club: Club, leagueNumber: String, positionNumber: Int): Club {
    return club.apply {
        league = "League $leagueNumber"
        position = positionNumber
        win = 0
        draw = 0
        lose = 0
        goalsFor = 0
        goalsAgainst = 0
        goalDifference = 0
        points = 0
    }
}