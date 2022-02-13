package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.ui.theme.Colors
import org.junit.Before
import org.junit.Test

class GetColorOfClubInTableTest {

    private lateinit var getColorOfClubInTable: GetColorOfClubInTable

    @Before
    fun setUp() {

        getColorOfClubInTable = GetColorOfClubInTable()
    }

    @Test
    fun `check that the color is correct for the first 4 places`() {

        val position = (1..4).random()

        val result = getColorOfClubInTable(position)

       assertThat(result).isEqualTo(Colors.LightGreen20)
    }

    @Test
    fun `check that the color is correct for the last 4 places`() {

        val position = (17..20).random()

        val result = getColorOfClubInTable(position)

        assertThat(result).isEqualTo(Colors.LightRed20)
    }

    @Test
    fun `check that the color is correct for the middle positions in the table`() {

        val position = (5..16).random()

        val result = getColorOfClubInTable(position)

        assertThat(result).isEqualTo(Color.Transparent)
    }
}