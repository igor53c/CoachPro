package com.ipcoding.coachpro.feature.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.feature.data.repository.FakeClubRepository
import com.ipcoding.coachpro.feature.domain.model.Club
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetClubPositionStringTest {

    private lateinit var fakeClubRepository: FakeClubRepository
    private lateinit var getClubPositionString: GetClubPositionString
    private lateinit var name: String
    private lateinit var club: Club

    @Before
    fun setUp() {
        fakeClubRepository = FakeClubRepository()
        getClubPositionString = GetClubPositionString(fakeClubRepository)

        name = "name"
        club = Club(
            name = name,
            league = "",
            position = 10,
            rating = 0.0,
            win = 0,
            draw = 0,
            lose = 0,
            goalsFor = 0,
            goalsAgainst = 0,
            goalDifference = 0,
            points = 0,
            0.0
        )
    }

    @Test
    fun `checking that the text of the club's position is correct`() {

        var result: String

        runBlocking {
            fakeClubRepository.insertClub(club)
            result = getClubPositionString(name)
        }

        assertThat(result).isEqualTo("10th")
    }

    @Test
    fun `checking that the text of the club in the first position is correct`() {

        var result: String
        club.position = 1

        runBlocking {
            fakeClubRepository.insertClub(club)
            result = getClubPositionString(name)
        }

        assertThat(result).isEqualTo("1st")
    }

    @Test
    fun `check that the text of the club in the second position is correct`() {

        var result: String
        club.position = 2

        runBlocking {
            fakeClubRepository.insertClub(club)
            result = getClubPositionString(name)
        }

        assertThat(result).isEqualTo("2nd")
    }

    @Test
    fun `checking that the text of the club in the third position is correct`() {

        var result: String
        club.position = 3

        runBlocking {
            fakeClubRepository.insertClub(club)
            result = getClubPositionString(name)
        }

        assertThat(result).isEqualTo("3rd")
    }

    @Test
    fun `checking whether the text of the club in the fourth or higher position is correct`() {

        var result: String

        for (i in 4..18) {
            club.position = i

            runBlocking {
                fakeClubRepository.insertClub(club)
                result = getClubPositionString(name)
            }

            assertThat(result).isEqualTo("${i}th")
        }
    }
}