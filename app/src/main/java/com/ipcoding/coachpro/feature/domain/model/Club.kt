package com.ipcoding.coachpro.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubs_table")
data class Club(
    val name: String,
    val league: String,
    val position: Int,
    var rating: Double,
    val win: Int,
    val draw: Int,
    val lose: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int,
    val points: Int,
    var playersRating: Double,
    @PrimaryKey val id: Int? = null
)
