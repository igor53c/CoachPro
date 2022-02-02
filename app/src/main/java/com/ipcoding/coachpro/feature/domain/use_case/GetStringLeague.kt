package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.feature.domain.model.Player

class GetStringLeague {

    operator fun invoke(number: String): String {
        return "League " + number
    }
}