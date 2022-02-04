package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ipcoding.coachpro.feature.domain.model.*

@Database(entities = [Player::class, Club::class, History::class, Match::class, Matches::class],
    version = 1)
abstract class CoachDatabase: RoomDatabase() {

    abstract val playerDao: PlayerDao
    abstract val clubDao: ClubDao
    abstract val historyDao: HistoryDao
    abstract val matchDao: MatchDao
    abstract val matchesDao: MatchesDao

    companion object {
        const val DATABASE_NAME = "coach_db"
    }
}