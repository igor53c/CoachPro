package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.domain.resources.ResourceProvider
import com.ipcoding.coachpro.core.util.Constants.END_MATCHES_ONE
import com.ipcoding.coachpro.core.util.Constants.END_MATCHES_TWO
import com.ipcoding.coachpro.core.util.Constants.END_TRANSFERS_ONE
import com.ipcoding.coachpro.core.util.Constants.END_TRANSFERS_TWO
import com.ipcoding.coachpro.core.util.Constants.SCHEDULING_TEXT
import com.ipcoding.coachpro.core.util.Constants.SEASON_IS_OVER
import com.ipcoding.coachpro.core.util.Constants.START_MATCHES_ONE
import com.ipcoding.coachpro.core.util.Constants.START_MATCHES_TWO
import com.ipcoding.coachpro.core.util.Constants.START_TRANSFERS_ONE
import com.ipcoding.coachpro.core.util.Constants.START_TRANSFERS_TWO
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository
import com.ipcoding.coachpro.feature.domain.util.WeekType

class GetWeekTypeText(
    private val preferences: Preferences,
    private val matchRepository: MatchRepository,
    private val clubRepository: ClubRepository,
    private val resourceProvider: ResourceProvider
) {

    suspend operator fun invoke(week: Int, withText: Boolean): WeekType {

        var tacticsText = ""
        var seasonOverText = ""

        if (withText) {
            val league = preferences.loadSelectedLeague()
            val round = preferences.loadRoundNumber() + 1
            val clubName = preferences.loadClubName()
            val myClub = clubName?.let { clubRepository.getClub(it) }
            val match = matchRepository.getClubMatch(round, clubName)
            val host = match?.host?.let { clubRepository.getClub(it) }
            val guest = match?.guest?.let { clubRepository.getClub(it) }

            tacticsText = "${resourceProvider.getString(R.string.league)} $league\n\n" +
                    "${resourceProvider.getString(R.string.round)}: $round\n\n\n" +
                    "${match?.host}" + "\n" +
                    host?.position?.let { positionString(it) } + "\n\n" +
                    resourceProvider.getString(R.string.vs) + "\n\n" +
                    "${match?.guest}" + "\n" +
                    guest?.position?.let { positionString(it) }

            seasonOverText = "${resourceProvider.getString(R.string.league)} $league\n\n" +
                    "${resourceProvider.getString(R.string.season_over)}\n\n\n" +
                    "$clubName\n" +
                    "${resourceProvider.getString(R.string.won)}\n" +
                    myClub?.position?.let { positionString(it) } +
                    " ${resourceProvider.getString(R.string.place)}\n"
        }

        val weekType: WeekType = when (if (week == 53) 1 else week) {

            in START_TRANSFERS_TWO..END_TRANSFERS_TWO -> {
                WeekType.Transfers(resourceProvider.getString(R.string.offer_player))
            }
            in START_MATCHES_TWO..END_MATCHES_TWO -> {
                WeekType.Tactics(tacticsText)
            }
            SEASON_IS_OVER -> WeekType.Else(seasonOverText)
            SCHEDULING_TEXT -> {
                WeekType.Else(resourceProvider.getString(R.string.schedule_new_season))
            }
            in START_TRANSFERS_ONE..END_TRANSFERS_ONE -> {
                WeekType.Transfers(resourceProvider.getString(R.string.offer_player))
            }
            in START_MATCHES_ONE..END_MATCHES_ONE -> WeekType.Tactics(tacticsText)
            else -> {
                WeekType.Else(resourceProvider.getString(R.string.preparations_new_season))
            }
        }

        return weekType
    }
}