package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository

class FakeClubRepository : ClubRepository {

    private var clubs = mutableListOf<Club>()

    override suspend fun insertClub(club: Club) {
        clubs.add(club)
    }

    override suspend fun deleteAll() {
        clubs.clear()
    }

    override suspend fun getRatingFromClub(name: String): Double {
        return clubs.find { it.name == name }?.rating ?: 0.0
    }

    override suspend fun getPlayersRating(name: String): Double {
        return clubs.find { it.name == name }?.playersRating ?: 0.0
    }

    override suspend fun getClubsFromLeague(league: String): List<Club> {
        return clubs.filter { it.league == league }
    }

    override suspend fun getClubsFromLeagueByPosition(league: String): List<Club> {
        return clubs.filter { it.league == league }.sortedBy { it.position }
    }

    override suspend fun getClubsFromLeagueByRating(league: String): List<Club> {
        return clubs.filter { it.league == league }.sortedBy { it.rating }
    }

    override suspend fun getClub(name: String): Club? {
        return clubs.find { it.name == name }
    }
}