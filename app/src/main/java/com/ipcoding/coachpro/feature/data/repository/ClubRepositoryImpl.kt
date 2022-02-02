package com.ipcoding.coachpro.feature.data.repository

import com.ipcoding.coachpro.feature.data.data_source.ClubDao
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository
import kotlinx.coroutines.flow.Flow

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

    override fun getClubsFromLeague(league: String): Flow<List<Club>> {
        return dao.getClubsFromLeague(league)
    }

    override fun getClubsFromLeagueByPosition(league: String): Flow<List<Club>> {
        return dao.getClubsFromLeagueByPosition(league)
    }

    override fun getClubsFromLeagueByRating(league: String): Flow<List<Club>> {
        return dao.getClubsFromLeagueByRating(league)
    }

    override suspend fun getClub(club: String): Club? {
        return dao.getClub(club)
    }
}