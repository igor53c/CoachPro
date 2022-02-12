package com.ipcoding.coachpro.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players_table")
data class Player(
    val name: String,
    var position: String,
    var rating: Double,
    var age: Int,
    var number: Int,
    var motivation: Int,
    var fitness: Int,
    var training: Int,
    @PrimaryKey val id: Int? = null
)
