package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.feature.domain.repository.MatchesRepository
import com.ipcoding.coachpro.feature.domain.util.FormMatch
import com.ipcoding.coachpro.ui.theme.Colors

class GetFormMatches(
    private val matchesRepository: MatchesRepository
) {

    suspend operator fun invoke(): List<FormMatch> {

        val listMatch = mutableListOf<FormMatch>()

        matchesRepository.getLastTenMatches().forEach { match ->
            when {
                match.goalsFor > match.goalsAgainst ->
                    listMatch.add(FormMatch("W", Colors.LightGreen20))
                match.goalsFor < match.goalsAgainst ->
                    listMatch.add(FormMatch("L", Colors.LightRed20))
                else -> listMatch.add(FormMatch("D", Colors.LightYellow))
            }
        }

        repeat(10 - listMatch.size) {
            listMatch.add(FormMatch("", Color.Transparent))
        }

        return listMatch
    }
}