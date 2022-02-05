package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.AllClubs
import com.ipcoding.coachpro.core.util.AllPlayers
import com.ipcoding.coachpro.core.util.AllPosition
import com.ipcoding.coachpro.core.util.AllTactics
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.repository.*
import kotlin.math.round
import kotlin.random.Random

class CreateClubDatabase(
    private val playerRepository: PlayerRepository,
    private val clubRepository: ClubRepository,
    private val historyRepository: HistoryRepository,
    private val matchRepository: MatchRepository,
    private val matchesRepository: MatchesRepository
) {
    private val players = mutableListOf<Player>()
    private var myLeague = ""

    suspend operator fun invoke(clubName: String) {
        insertAllClubsInDatabase(clubName)
    }

    private suspend fun insertAllClubsInDatabase(clubName: String) {

        clubRepository.deleteAll()
        matchRepository.deleteAll()
        historyRepository.deleteAll()
        matchesRepository.deleteAll()

        for (i in 0..139) {
            var league = ""
            var rating = 0.0
            when(i) {
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
            val currentClubName : String = AllClubs().getClub(i)
            val club = Club(currentClubName, league, i % 20 + 1, rating, 0,
                0, 0, 0, 0, 0, 0, rating)
            if (currentClubName == clubName) {
                myLeague = league
                insertAllPlayersInDatabase(rating)
                club.playersRating = CalculationTeamRating().invoke(players)
                club.rating = CalculationFirstTeamRating().invoke(
                    players = players,
                    tactics = AllTactics.T_442
                )
                clubRepository.insertClub(club)
            } else clubRepository.insertClub(club)
        }
        MakeSchedule(clubRepository, matchRepository).invoke(myLeague)
    }

    private suspend fun insertAllPlayersInDatabase(clubRating: Double) {

        playerRepository.deleteAll()

        for (number in 0..17) {
            var position = ""
            when(number) {
                in 0..1 -> position = AllPosition.GK
                in 2..7 -> position = AllPosition.DEF[Random.nextInt(6)]
                in 8..13 -> position = AllPosition.MID[Random.nextInt(6)]
                in 14..17 -> position = AllPosition.FOR[Random.nextInt(6)]
            }
            val rating = takeRandomNumberFromRange(
                round(clubRating - 8).toInt(),
                round(clubRating + 4).toInt()
            )
            val age = if (clubRating - rating < 0) {
                takeRandomNumberFromRange(31, 36)
            } else {
                if (clubRating - rating < 4) {
                    takeRandomNumberFromRange(24, 30)
                } else {
                    takeRandomNumberFromRange(18, 23)
                }
            }
            val player = Player(makeName(), position, rating.toDouble(),
                age, number, 100, 100, 0)
            players.add(player)
            playerRepository.insertPlayer(player)
        }
    }

    private fun makeName(): String {
        return takeRandomLetter().toString() + " " +
                AllPlayers().players[Random.nextInt(AllPlayers().playersSize())]
    }

    private fun takeRandomNumberFromRange(min: Int, max: Int): Int {
        return (Math.random() * (max - min + 1)).toInt() + min
    }

    private fun takeRandomLetter(): Char {
        return ('A'.code + Random.nextInt(26)).toChar()
    }
}