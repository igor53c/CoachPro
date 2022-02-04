package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.data.data_source.ClubDao
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository

class ClubRepositoryImpl(
    private val dao: ClubDao
): ClubRepository {

    override suspend fun insertClub(club: Club) {
        dao.insertClub(club)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun getRatingFromClub(name: String): Double {
        return dao.getRatingFromClub(name)
    }

    override suspend fun getClubsFromLeague(league: String): List<Club> {
        return dao.getClubsFromLeague(league)
    }

    override suspend fun getClubsFromLeagueByPosition(league: String): List<Club> {
        return dao.getClubsFromLeagueByPosition(league)
    }

    override suspend fun getClubsFromLeagueByRating(league: String): List<Club> {
        return dao.getClubsFromLeagueByRating(league)
    }

    override suspend fun getClub(club: String): Club? {
        return dao.getClub(club)
    }
}