package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.AllClubs

class GetClubsFromLeague {

    operator fun invoke(league: String?): Array<String> {
        var clubs: Array<String> = emptyArray()
        val allClubs = AllClubs()

        when(league) {
            "1" -> clubs = allClubs.clubs.copyOfRange(0, 20)
            "2" -> clubs = allClubs.clubs.copyOfRange(20, 40)
            "3" -> clubs = allClubs.clubs.copyOfRange(40, 60)
            "4" -> clubs = allClubs.clubs.copyOfRange(60, 80)
            "5" -> clubs = allClubs.clubs.copyOfRange(80, 100)
            "6" -> clubs = allClubs.clubs.copyOfRange(100, 120)
            "7" -> clubs = allClubs.clubs.copyOfRange(120, 140)
        }
        return clubs
    }
}
