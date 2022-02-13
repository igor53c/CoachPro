package com.ipcoding.coachpro.feature.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.feature.domain.model.Player
import org.junit.Before
import org.junit.Test

class CalculationTeamRatingTest {

    private lateinit var calculationTeamRating: CalculationTeamRating

    @Before
    fun setUp() {
        calculationTeamRating = CalculationTeamRating()
    }

    @Test
    fun `whether the rating of the team was calculated correctly`() {
        val players = (0..17).map {
            Player(
                name = "name",
                position = "",
                rating = (it + 1).toDouble(),
                age = 20,
                number = 1,
                motivation = 100,
                fitness = 0,
                training = 0
            )
        }

        val result = calculationTeamRating(players)
        var expectedResult = 0.0

        for (i in 0..17) { expectedResult += (i + 1).toDouble() }
        expectedResult /= 18.0

        assertThat(result).isEqualTo(expectedResult)
    }
}