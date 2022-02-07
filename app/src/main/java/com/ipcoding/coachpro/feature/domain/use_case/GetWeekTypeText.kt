package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.util.WeekType

class GetWeekTypeText {

    operator fun invoke(weekParameter: Int): WeekType {

        val weekType: WeekType = when(if(weekParameter == 53) 1 else weekParameter) {
            in 1..3 -> {
                WeekType.Transfers("Player transfer!")
            }
            in 4..21 -> {
                WeekType.Tactics(
                    "League 1" + "\n\n" +
                            "Round: " + "5" + "\n\n\n" +
                            "domacin" + "\n" +
                            "5" + "th" + "\n\n" +
                            "VS" + "\n\n" +
                            "gost" + "\n" +
                            "7" + "th"
                )
            }
            23 -> {
                WeekType.Else(
                    "League 1" + "\n\n" + "The season is over!" + "\n\n\n" + "myClub" + "\n" +
                            "won\n" + "10" + "th place!"
                )
            }
            25 -> WeekType.Schedule(
                "League 1" + "\n\n" + "The schedule for the new season has come out!"
            )
            in 26..30 -> {
                WeekType.Transfers("Player transfer!")
            }
            in 34..52 -> {
                WeekType.Tactics(
                    "League 1" + "\n\n" +
                            "Round: " + "5" + "\n\n\n" +
                            "domacin" + "\n" +
                            "5" + "th" + "\n\n" +
                            "VS" + "\n\n" +
                            "gost" + "\n" +
                            "7" + "th"
                )
            }
            else -> {
                WeekType.Else("Else")
            }
        }

        return weekType
    }
}