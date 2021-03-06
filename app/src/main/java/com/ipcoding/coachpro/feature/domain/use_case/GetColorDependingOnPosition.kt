package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import com.ipcoding.coachpro.core.util.InputData.DEF
import com.ipcoding.coachpro.core.util.InputData.FOR
import com.ipcoding.coachpro.core.util.InputData.GK
import com.ipcoding.coachpro.core.util.InputData.MID
import com.ipcoding.coachpro.ui.theme.Colors.LightBlue
import com.ipcoding.coachpro.ui.theme.Colors.LightGreen10
import com.ipcoding.coachpro.ui.theme.Colors.LightRed10
import com.ipcoding.coachpro.ui.theme.Colors.LightYellow

class GetColorDependingOnPosition {

    operator fun invoke(position: String): Color {
        return when (position) {
            GK -> LightGreen10
            in DEF -> LightBlue
            in MID -> LightYellow
            in FOR -> LightRed10
            else -> Transparent
        }
    }
}