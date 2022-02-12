package com.ipcoding.coachpro.feature.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.ui.theme.Colors
import org.junit.Before
import org.junit.Test

class GetColorDependingOnPositionTest {

    private lateinit var getColorDependingOnPosition: GetColorDependingOnPosition

    @Before
    fun setUp() {
        getColorDependingOnPosition = GetColorDependingOnPosition()
    }

    @Test
    fun `check that the color is correct for the goalkeeper`() {

        val position = "GK"

        val result = getColorDependingOnPosition.invoke(position)

        assertThat(result).isEqualTo(Colors.LightGreen10)
    }

    @Test
    fun `check that the color is correct for the defensive player`() {

        val position = "DR"

        val result = getColorDependingOnPosition.invoke(position)

        assertThat(result).isEqualTo(Colors.LightBlue)
    }

    @Test
    fun `check that the color is correct for the midfielder`() {

        val position = "ML"

        val result = getColorDependingOnPosition.invoke(position)

        assertThat(result).isEqualTo(Colors.LightYellow)
    }

    @Test
    fun `checking that the color is correct for the attacking player`() {

        val position = "FRC"

        val result = getColorDependingOnPosition.invoke(position)

        assertThat(result).isEqualTo(Colors.LightRed10)
    }
}