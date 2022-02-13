package com.ipcoding.coachpro.feature.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.core.util.Constants.T_433
import com.ipcoding.coachpro.feature.domain.model.Player
import org.junit.Before
import org.junit.Test

class CalculationFirstTeamRatingTest {

    private lateinit var calculationFirstTeamRating: CalculationFirstTeamRating

    @Before
    fun setUp() {
        calculationFirstTeamRating = CalculationFirstTeamRating()
    }

    @Test
    fun `whether the rating of the first team was calculated correctly`() {
        val position = listOf("GK", "DR", "DC", "DC", "DL", "MC", "MC", "MC", "FR", "FC", "FL",
            "GK", "DR", "DC", "DC", "DL", "MC", "MC")
        val players = (0..17).map {
            Player(
                name = "name",
                position = position[it],
                rating = (it + 1).toDouble(),
                age = 20,
                number = 1,
                motivation = 100,
                fitness = 0,
                training = 0
            )
        }

        val tactics = T_433
        val result = calculationFirstTeamRating(players, tactics)
        var expectedResult = 0.0

        for (i in 0..10) { expectedResult += (i + 1).toDouble() }
        expectedResult /= 11.0

        assertThat(result).isEqualTo(expectedResult)
    }
}