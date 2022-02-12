package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.core.util.AllPosition.Companion.DEF
import com.ipcoding.coachpro.core.util.AllPosition.Companion.FOR
import com.ipcoding.coachpro.core.util.AllPosition.Companion.GK
import com.ipcoding.coachpro.core.util.AllPosition.Companion.MID
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