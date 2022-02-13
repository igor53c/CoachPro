package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.core.util.Constants.DEF
import com.ipcoding.coachpro.core.util.Constants.FOR
import com.ipcoding.coachpro.core.util.Constants.GK
import com.ipcoding.coachpro.core.util.Constants.MID
import com.ipcoding.coachpro.ui.theme.Colors

class GetColorDependingOnPosition {

    operator fun invoke(position: String): Color {
        var color = Color.Transparent
        when(position) {
            GK -> color = Colors.LightGreen10
            in DEF -> color = Colors.LightBlue
            in MID -> color = Colors.LightYellow
            in FOR -> color = Colors.LightRed10
        }
        return color
    }
}