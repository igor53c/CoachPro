package com.ipcoding.coachpro.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubs_table")
data class Club(
    val name: String,
    val league: String,
    val position: Int,
    val rating: Double,
    val win: Int,
    val draw: Int,
    val lose: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int,
    val points: Int,
    @PrimaryKey val id: Int? = null
)
