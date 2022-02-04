package com.ipcoding.coachpro.feature.domain.model

import androidx.compose.ui.graphics.Color

class MarkedPlayer(
    var player: Player? = null,
    var item1: Int = -1,
    var item2: Int = -1,
    var color: Color = Color.Transparent,
    var isPlayerClicked: Boolean = false,
    var newPlayer: Player? = null
)