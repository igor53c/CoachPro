package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.ui.theme.Colors

class GetColorOfClubInTable {

    operator fun invoke(position: Int): Color {
        var color = Color.Transparent
        when(position) {
            in 1..4 -> color = Colors.LightGreen20
            in 17..20 -> color = Colors.LightRed20
        }
        return color
    }
}