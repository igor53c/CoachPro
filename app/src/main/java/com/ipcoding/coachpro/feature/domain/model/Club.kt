package com.ipcoding.coachpro.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clubs_table")
data class Club(
    val name: String,
    var league: String,
    var position: Int,
    var rating: Double,
    var win: Int = 0,
    var draw: Int = 0,
    var lose: Int = 0,
    var goalsFor: Int = 0,
    var goalsAgainst: Int = 0,
    var goalDifference: Int = 0,
    var points: Int = 0,
    var playersRating: Double,
    @PrimaryKey val id: Int? = null
)
