package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player

class GetPlayerInfo {

    operator fun invoke(player: Player?): String {
        var playerInfo = ""
        player?.let {
            playerInfo = player.position + " " +  player.rating.toString()
        }
        return playerInfo
    }
}