package com.ipcoding.coachpro.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players_table")
data class Player(
    val name: String,
    val position: String,
    val rating: Double,
    val age: Int,
    val number: Int,
    val motivation: Int,
    val fitness: Int,
    var training: Int,
    @PrimaryKey val id: Int? = null
)
