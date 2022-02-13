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
    var motivation: Int = 100,
    var fitness: Int = 100,
    var training: Int = 0,
    var transferPlayer: Boolean = false,
    var value: Double = 0.0,
    @PrimaryKey val id: Int? = null
)
