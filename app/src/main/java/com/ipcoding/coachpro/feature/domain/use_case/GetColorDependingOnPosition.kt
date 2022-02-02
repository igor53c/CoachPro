package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.core.util.AllPosition
import com.ipcoding.coachpro.core.util.Colors

class GetColorDependingOnPosition {

    operator fun invoke(position: String): Color {
        var color = Color.White
        when(position) {
            AllPosition.GK -> color = Colors.LightGreen
            in AllPosition.DEF -> color = Colors.LightBlue
            in AllPosition.MID -> color = Colors.LighYellow
            in AllPosition.FOR -> color = Colors.LighRed
        }
        return color
    }
}