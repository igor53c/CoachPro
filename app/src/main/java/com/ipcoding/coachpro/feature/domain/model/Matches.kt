package com.ipcoding.coachpro.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches_table")
data class Matches(
    val opponent: String,
    val place: String,
    val goalsFor: Int,
    val goalsAgainst: Int,
    @PrimaryKey val id: Int? = null
)
