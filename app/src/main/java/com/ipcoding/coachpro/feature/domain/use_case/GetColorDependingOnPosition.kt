package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.core.util.AllPosition
import com.ipcoding.coachpro.ui.theme.Colors

class GetColorDependingOnPosition {

    operator fun invoke(position: String): Color {
        var color = Color.Transparent
        when(position) {
            AllPosition.GK -> color = Colors.LightGreen10
            in AllPosition.DEF -> color = Colors.LightBlue
            in AllPosition.MID -> color = Colors.LightYellow
            in AllPosition.FOR -> color = Colors.LightRed10
        }
        return color
    }
}