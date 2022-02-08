package com.ipcoding.coachpro.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubs_table")
data class Club(
    val name: String,
    val league: String,
    var position: Int,
    var rating: Double,
    var win: Int,
    var draw: Int,
    var lose: Int,
    var goalsFor: Int,
    var goalsAgainst: Int,
    var goalDifference: Int,
    var points: Int,
    var playersRating: Double,
    @PrimaryKey val id: Int? = null
)
