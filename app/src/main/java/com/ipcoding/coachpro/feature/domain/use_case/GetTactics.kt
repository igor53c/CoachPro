package com.ipcoding.coachpro.feature.domain.use_case

import com.ipcoding.coachpro.core.util.InputData.T_343
import com.ipcoding.coachpro.core.util.InputData.T_352
import com.ipcoding.coachpro.core.util.InputData.T_433
import com.ipcoding.coachpro.core.util.InputData.T_442
import com.ipcoding.coachpro.core.util.InputData.T_451
import com.ipcoding.coachpro.core.util.InputData.T_532
import com.ipcoding.coachpro.core.util.InputData.T_541

class GetTactics {

    operator fun invoke(name: String): List<Any> {
        return when(name) {
            "5-4-1" -> T_541
            "5-3-2" -> T_532
            "4-5-1" -> T_451
            "4-4-2" -> T_442
            "4-3-3" -> T_433
            "3-5-2" -> T_352
            "3-4-3" -> T_343
            else -> emptyList()
        }
    }
}