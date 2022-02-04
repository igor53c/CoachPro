package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player

class GetPlayer {

    operator fun invoke(
        players: List<Player>,
        tactics: List<Any>,
        item1: Int,
        item2: Int
    ): Player? {
        var player: Player? = null
        if(players.size > 0) {
            var num = 0
            var i = 0
            while (i < item1) {
                num += tactics[i + 1] as Int
                i++
            }
            num += item2
            player = players[num]
        }
        return player
    }
}