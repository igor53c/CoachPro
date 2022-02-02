package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.AllClubs

class GetClubsFromLeague {

    operator fun invoke(league: String?): Array<String> {
        var clubs: Array<String> = emptyArray()
        when(league) {
            "1" -> clubs = AllClubs().clubs.copyOfRange(0, 20)
            "2" -> clubs = AllClubs().clubs.copyOfRange(20, 40)
            "3" -> clubs = AllClubs().clubs.copyOfRange(40, 60)
            "4" -> clubs = AllClubs().clubs.copyOfRange(60, 80)
            "5" -> clubs = AllClubs().clubs.copyOfRange(80, 100)
            "6" -> clubs = AllClubs().clubs.copyOfRange(100, 120)
            "7" -> clubs = AllClubs().clubs.copyOfRange(120, 140)
        }
        return clubs
    }
}
