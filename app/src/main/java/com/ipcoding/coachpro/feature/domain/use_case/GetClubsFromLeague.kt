package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.InputData.ALL_CLUBS

class GetClubsFromLeague {

    operator fun invoke(league: String?): Array<String> {

        var clubs: Array<String> = emptyArray()

        when (league) {
            "1" -> clubs = ALL_CLUBS.copyOfRange(0, 20)
            "2" -> clubs = ALL_CLUBS.copyOfRange(20, 40)
            "3" -> clubs = ALL_CLUBS.copyOfRange(40, 60)
            "4" -> clubs = ALL_CLUBS.copyOfRange(60, 80)
            "5" -> clubs = ALL_CLUBS.copyOfRange(80, 100)
            "6" -> clubs = ALL_CLUBS.copyOfRange(100, 120)
            "7" -> clubs = ALL_CLUBS.copyOfRange(120, 140)
        }
        return clubs
    }
}
