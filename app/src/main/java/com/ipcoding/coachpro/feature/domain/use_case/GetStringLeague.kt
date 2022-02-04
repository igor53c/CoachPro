package com.ipcoding.coachpro.feature.domain.use_case

class GetStringLeague {

    operator fun invoke(number: String): String {
        return "League $number"
    }
}