package com.ipcoding.coachpro.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "match_table")
data class Match(
    val round: Int,
    val host: String,
    val guest: String,
    var goalsHost: Int,
    var goalsGuest: Int,
    @PrimaryKey val id: Int? = null
)
