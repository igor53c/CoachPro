package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.util.InputData.ALL_CLUBS
import com.ipcoding.coachpro.core.util.InputData.ALL_PLAYERS
import com.ipcoding.coachpro.core.util.InputData.DEF
import com.ipcoding.coachpro.core.util.InputData.FOR
import com.ipcoding.coachpro.core.util.InputData.GK
import com.ipcoding.coachpro.core.util.InputData.MID
import com.ipcoding.coachpro.core.util.InputData.T_442
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.*
import kotlin.math.pow
import kotlin.random.Random

class CreateClubDatabase(
    private val playerRepository: PlayerRepository,
    private val clubRepository: ClubRepository,
    private val historyRepository: HistoryRepository,
    private val matchRepository: MatchRepository,
    private val matchesRepository: MatchesRepository,
    private val preferences: Preferences
) {
    private var players = mutableListOf<Player>()
    private var myLeague = ""

    suspend operator fun invoke(clubName: String) {
        insertAllClubsInDatabase(clubName)
    }

    private suspend fun insertAllClubsInDatabase(clubName: String) {

        players = mutableListOf()
        playerRepository.deleteAll()
        clubRepository.deleteAll()
        matchRepository.deleteAll()
        historyRepository.deleteAll()
        matchesRepository.deleteAll()

        for (i in 0..139) {
            var league = ""
            var rating = 0.0
            when (i) {
                in 0..19 -> {
                    league = "League 1"
                    rating = 85 + 10 - i % 20.0 / 2
                }
                in 20..39 -> {
                    league = "League 2"
                    rating = 75 + 10 - i % 20.0 / 2
                }
                in 40..59 -> {
                    league = "League 3"
                    rating = 65 + 10 - i % 20.0 / 2
                }
                in 60..79 -> {
                    league = "League 4"
                    rating = 55 + 10 - i % 20.0 / 2
                }
                in 80..99 -> {
                    league = "League 5"
                    rating = 45 + 10 - i % 20.0 / 2
                }
                in 100..119 -> {
                    league = "League 6"
                    rating = 35 + 10 - i % 20.0 / 2
                }
                in 120..139 -> {
                    league = "League 7"
                    rating = 25 + 10 - i % 20.0 / 2
                }
            }
            val currentClubName: String = ALL_CLUBS[i]
            val club = Club(
                currentClubName, league, i % 20 + 1, rating,
                playersRating = rating
            )
            if (currentClubName == clubName) {
                myLeague = league
                insertAllPlayersInDatabase(rating)
                club.playersRating = CalculationTeamRating()(players)
                club.rating = CalculationFirstTeamRating()(
                    players = players,
                    tactics = T_442
                )
                preferences.saveBudget((1.06421f).pow(rating.toFloat() - 25f) * 0.5f)
                clubRepository.insertClub(club)
            } else clubRepository.insertClub(club)
        }
        MakeSchedule(clubRepository, matchRepository)(myLeague)
    }

    private suspend fun insertAllPlayersInDatabase(clubRating: Double) {

        for (number in 1..18) {
            var position = ""
            when (number) {
                in 1..2 -> position = GK
                in 3..8 -> position = DEF.random()
                in 9..14 -> position = MID.random()
                in 15..18 -> position = FOR.random()
            }

            val rating = randomDouble(clubRating - 8, clubRating + 4)

            val age = when {
                rating > clubRating -> (31..36).random()
                rating > clubRating - 4 -> (24..30).random()
                else -> (18..23).random()
            }

            val player = Player(makeName(), position, rating, age, number)
            players.add(player)
            playerRepository.insertPlayer(player)
        }
    }
}

fun randomDouble(min: Double, max: Double): Double {
    val value = ((min * 10).toInt()..(max * 10).toInt()).random() / 10.0
    return when {
        value > 99.0 -> 99.0
        value < 1.0 -> 1.0
        else -> value
    }
}

fun makeName(): String {
    return ALL_PLAYERS[Random.nextInt(ALL_PLAYERS.size)] + " " + ('A'..'Z').random()
}