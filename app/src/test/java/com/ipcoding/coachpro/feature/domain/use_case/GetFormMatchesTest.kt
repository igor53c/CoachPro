package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.feature.data.repository.FakeMatchesRepository
import com.ipcoding.coachpro.feature.domain.model.Matches
import com.ipcoding.coachpro.feature.domain.repository.MatchesRepository
import com.ipcoding.coachpro.feature.domain.util.FormMatch
import com.ipcoding.coachpro.ui.theme.Colors
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetFormMatchesTest {

    private lateinit var fakeMatchesRepository: MatchesRepository
    private lateinit var winMatch: Matches
    private lateinit var loseMatch: Matches
    private lateinit var drawMatch: Matches

    @Before
    fun setUp() {
        fakeMatchesRepository = FakeMatchesRepository()
        winMatch = Matches(
            opponent = "",
            place = "",
            goalsFor = 1,
            goalsAgainst = 0
        )
        loseMatch = Matches(
            opponent = "",
            place = "",
            goalsFor = 0,
            goalsAgainst = 1
        )
        drawMatch = Matches(
            opponent = "",
            place = "",
            goalsFor = 1,
            goalsAgainst = 1
        )
    }

    @Test
    fun `check if he returns the list without registered matches`() {

        var result: List<FormMatch>

        runBlocking {
            result = GetFormMatches(fakeMatchesRepository)()
        }

        val expectedResult = mutableListOf<FormMatch>()

        repeat(10) { expectedResult.add(FormMatch("", Color.Transparent)) }

        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun `check if he returns the list with three registered matches`() {

        var result: List<FormMatch>

        runBlocking {

            fakeMatchesRepository.insertMatches(winMatch)
            fakeMatchesRepository.insertMatches(loseMatch)
            fakeMatchesRepository.insertMatches(drawMatch)

            result = GetFormMatches(fakeMatchesRepository)()
        }

        val expectedResult = mutableListOf<FormMatch>()

        expectedResult.add(FormMatch("W", Colors.LightGreen20))
        expectedResult.add(FormMatch("L", Colors.LightRed20))
        expectedResult.add(FormMatch("D", Colors.LightYellow))

        repeat(10 - expectedResult.size) {
            expectedResult.add(FormMatch("", Color.Transparent))
        }

        assertThat(result).isEqualTo(expectedResult)
    }

    @Test
    fun `check if he returns the list of ten registered matches`() {

        var result: List<FormMatch>

        runBlocking {

            repeat(4) {
                repeat(4) {
                    fakeMatchesRepository.insertMatches(winMatch)
                    fakeMatchesRepository.insertMatches(loseMatch)
                    fakeMatchesRepository.insertMatches(drawMatch)
                }
            }

            result = GetFormMatches(fakeMatchesRepository)()
        }

        val expectedResult = mutableListOf<FormMatch>()

        repeat(3) {
            expectedResult.add(FormMatch("W", Colors.LightGreen20))
            expectedResult.add(FormMatch("L", Colors.LightRed20))
            expectedResult.add(FormMatch("D", Colors.LightYellow))
        }

        expectedResult.add(FormMatch("W", Colors.LightGreen20))

        assertThat(result).isEqualTo(expectedResult)
    }
}