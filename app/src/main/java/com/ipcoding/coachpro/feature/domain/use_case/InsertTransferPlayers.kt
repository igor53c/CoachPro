package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.Constants.ALL_POSITION
import com.ipcoding.coachpro.core.util.Constants.END_MATCHES_ONE
import com.ipcoding.coachpro.core.util.Constants.END_TRANSFERS_ONE
import com.ipcoding.coachpro.core.util.Constants.END_TRANSFERS_TWO
import com.ipcoding.coachpro.core.util.Constants.START_TRANSFERS_ONE
import com.ipcoding.coachpro.core.util.Constants.START_TRANSFERS_TWO
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.PlayerRepository
import kotlin.math.pow

class InsertTransferPlayers(
    private val playerRepository: PlayerRepository
) {

    private var clubRating = 0.0

    suspend operator fun invoke(rating: Double, week: Int) {

        clubRating = rating

        when(week) {
            START_TRANSFERS_ONE - 1 -> insertAllTransferPlayers()
            in START_TRANSFERS_ONE..END_TRANSFERS_ONE -> replaceTransferPlayers()
            END_MATCHES_ONE -> insertAllTransferPlayers()
            in START_TRANSFERS_TWO..END_TRANSFERS_TWO -> replaceTransferPlayers()
        }
    }

    private suspend fun replaceTransferPlayers() {
        val players = mutableListOf<Player>()
        players.addAll(playerRepository.getAllTransferPlayers())

        repeat(20 - players.size) {
            insertRandomTransferPlayer()
        }

        repeat(5) {
            if(players.size > 0) {
                val player = players[players.indices.random()]
                playerRepository.deletePlayer(player)
                players.remove(player)
                insertRandomTransferPlayer()
            }
        }
    }

    private suspend fun insertAllTransferPlayers() {

        playerRepository.deleteAllTransferPlayers()

        repeat(20) {
            insertRandomTransferPlayer()
        }
    }

    private suspend fun insertRandomTransferPlayer() {
        val position = ALL_POSITION.random()
        val ratingPlayer =  randomDouble(clubRating - 8, clubRating + 4)

        val age = when {
            ratingPlayer > clubRating -> (31..36).random()
            ratingPlayer > clubRating - 4 -> (24..30).random()
            else -> (18..23).random()
        }

        playerRepository.insertPlayer(
            Player(
                name = makeName(),
                position = position,
                rating = ratingPlayer,
                age = age,
                number = 0,
                transferPlayer = true,
                value = getRandomPlayerValue(ratingPlayer, age)
            )
        )
    }
}

fun getRandomPlayerValue(rating: Double, age: Int) : Double {
    var value = (1.06421).pow(rating - 25.0) * (1.0 +  (18.0 - age.toDouble()) / 20.0)
    value *= (5..15).random() / 10.0
    return when {
        value < 0.0 -> 0.0
        else -> value
    }
}