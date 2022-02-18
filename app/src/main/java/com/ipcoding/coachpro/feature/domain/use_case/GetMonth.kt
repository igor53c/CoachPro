package com.ipcoding.coachpro.feature.domain.use_case

import java.util.*

class GetMonth {

    operator fun invoke(week: Int, year: Int): String {

        val date = Calendar.getInstance()
        date.set(Calendar.YEAR, year)
        date.set(Calendar.DAY_OF_YEAR, week * 7)
        return String.format(Locale.UK, "%tB", date)
    }
}