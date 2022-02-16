package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.InputData.T_433
import com.ipcoding.coachpro.feature.domain.model.Player
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CheckPlayerInRightPositionTest {

    private lateinit var checkPlayerInRightPosition: CheckPlayerInRightPosition
    private lateinit var player: Player

    @Before
    fun setUp() {
        player = Player(
            name = "name",
            position = "GK",
            rating = 0.0,
            age = 20,
            number = 1,
            motivation = 0,
            fitness = 0,
            training = 0
        )
        checkPlayerInRightPosition = CheckPlayerInRightPosition()
    }

    @Test
    fun `check if goalkeeper is in the right position`() {

        val tactics = T_433
        val result = checkPlayerInRightPosition(player, 0, 0, tactics)

        assertTrue(result)
    }

    @Test
    fun `check if goalkeeper is not in the right position`() {

        val tactics = T_433
        val result = checkPlayerInRightPosition(player, 1, 0, tactics)

        assertFalse(result)
    }

    @Test
    fun `check if DC is in the right position`() {

        player.position = "DC"
        val tactics = T_433
        val result = checkPlayerInRightPosition(player, 1, 1, tactics)

        assertTrue(result)
    }

    @Test
    fun `check if DC is not in the right position`() {

        player.position = "DC"
        val tactics = T_433
        val result = checkPlayerInRightPosition(player, 0, 0, tactics)

        assertFalse(result)
    }
}