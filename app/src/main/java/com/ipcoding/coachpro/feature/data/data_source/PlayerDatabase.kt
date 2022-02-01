package com.ipcoding.coachpro.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ipcoding.coachpro.feature.domain.model.Player

@Database(
    entities = [Player::class],
    version = 1
)
abstract class PlayerDatabase: RoomDatabase() {

    abstract val playerDao: PlayerDao

    companion object {
        const val DATABASE_NAME = "player_db"
    }
}