package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.domain.resources.ResourceProvider
import com.ipcoding.coachpro.feature.domain.repository.ClubRepository
import com.ipcoding.coachpro.feature.domain.repository.MatchRepository
import com.ipcoding.coachpro.feature.domain.util.WeekType

class GetWeekTypeText(
    private val preferences: Preferences,
    private val matchRepository: MatchRepository,
    private val clubRepository: ClubRepository,
    private val resourceProvider: ResourceProvider
) {

    suspend operator fun invoke(weekParameter: Int, withText: Boolean): WeekType {

        var tacticsText = ""
        var scheduleText = ""
        var seasonOverText = ""

        if(withText) {
            val league = preferences.loadSelectedLeague()
            val round = preferences.loadRoundNumber() + 1
            val clubName = preferences.loadClubName()
            val myClub = clubName?.let { clubRepository.getClub(it) }
            val match = matchRepository.getClubMatchFromNextRound(round, clubName)
            val host = match?.host?.let { clubRepository.getClub(it) }
            val guest = match?.guest?.let { clubRepository.getClub(it) }

           tacticsText = resourceProvider.getString(R.string.league) + "$league\n\n" +
                    "${resourceProvider.getString(R.string.round)}: $round\n\n\n" +
                    "${match?.host}" + "\n" +
                    host?.position?.let { positionString(it) } + "\n\n" +
                   resourceProvider.getString(R.string.vs) + "\n\n" +
                    "${match?.guest}" + "\n" +
                    guest?.position?.let { positionString(it) }

            scheduleText = "${resourceProvider.getString(R.string.league)} $league\n\n" +
                    resourceProvider.getString(R.string.schedule_text)

            seasonOverText = "${resourceProvider.getString(R.string.league)} $league\n\n" +
                    "${resourceProvider.getString(R.string.season_over)}\n\n\n" +
                    "$clubName\n" +
                    "${resourceProvider.getString(R.string.won)}\n" +
                    myClub?.position?.let { positionString(it) }
        }

        val weekType: WeekType = when(if(weekParameter == 53) 1 else weekParameter) {
            in 1..3 -> WeekType.Transfers(resourceProvider.getString(R.string.player_transfer))
            in 4..22 -> WeekType.Tactics(tacticsText)
            23 -> WeekType.Else(seasonOverText)
            25 -> {
                preferences.saveRoundNumber(0)
                WeekType.Schedule(scheduleText)
            }
            in 26..30 -> WeekType.Transfers(resourceProvider.getString(R.string.player_transfer))
            in 34..52 -> WeekType.Tactics(tacticsText)
            else -> WeekType.Else("Else")
        }

        return weekType
    }
}