package com.ipcoding.coachpro.feature.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.feature.domain.model.Player
import org.junit.Before
import org.junit.Test

class GetPlayerInfoTest {

    private lateinit var getPlayerInfo: GetPlayerInfo
    private lateinit var player: Player

    @Before
    fun setUp() {

        getPlayerInfo = GetPlayerInfo()

        player = Player(
            name = "name",
            position = "GK",
            rating = 85.478596,
            age = 20,
            number = 1,
            motivation = 100,
            fitness = 0,
            training = 0
        )
    }

    @Test
    fun `check the text is correct`() {

        val result = getPlayerInfo.invoke(player)

        assertThat(result).isEqualTo("GK 85.5")
    }
}