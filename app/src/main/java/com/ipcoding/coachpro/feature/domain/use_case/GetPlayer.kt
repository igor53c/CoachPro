package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player

class GetPlayer {

    operator fun invoke(
        players: List<Player>,
        tactics: List<Any>,
        item1: Int,
        item2: Int
    ): Player? {

        var num = 0
        for (i in 0 until item1) {
            num += tactics[i + 1] as Int
        }
        num += item2
        return when {
            num < players.size -> players[num]
            else -> null
        }
    }
}