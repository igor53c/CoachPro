package com.ipcoding.coachpro.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class History(
    val year: Int,
    val league: String,
    val position: Int,
    @PrimaryKey val id: Int? = null
)
