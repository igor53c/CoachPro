package com.ipcoding.coachpro.feature.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.core.util.AllTactics
import com.ipcoding.coachpro.feature.domain.model.Player
import org.junit.Before
import org.junit.Test

class GetPlayerTest {

    private lateinit var getPlayer: GetPlayer
    private lateinit var players: List<Player>

    @Before
    fun setUp() {

        players = (0..17).map {
            Player(
                name = "name",
                position = "",
                rating = 0.0,
                age = 20,
                number = 1,
                motivation = 100,
                fitness = 0,
                training = 0
            )
        }

        getPlayer = GetPlayer()
    }

    @Test
    fun `check that the correct player has been taken`() {

        val tactics = AllTactics.T_433

        val result = getPlayer.invoke(players, tactics, 1, 3)

        assertThat(result).isEqualTo(players[4])
    }
}