package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.Constants.END_MATCHES_ONE
import com.ipcoding.coachpro.core.util.Constants.END_TRANSFERS_ONE
import com.ipcoding.coachpro.core.util.Constants.END_TRANSFERS_TWO
import com.ipcoding.coachpro.core.util.Constants.START_TRANSFERS_ONE
import com.ipcoding.coachpro.core.util.Constants.START_TRANSFERS_TWO

class TransferWindow {

    operator fun invoke(week: Int) : Boolean {
        return when(week) {
            in START_TRANSFERS_ONE - 1 .. END_TRANSFERS_ONE -> true
            END_MATCHES_ONE -> true
            in START_TRANSFERS_TWO..END_TRANSFERS_TWO -> true
            else -> false
        }
    }
}