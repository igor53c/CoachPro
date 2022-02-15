package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.ui.theme.Colors.LightGreen20
import com.ipcoding.coachpro.ui.theme.Colors.LightRed20

class GetColorOfClubInTable {

    operator fun invoke(position: Int): Color {

        return when(position) {
            in 1..4 -> LightGreen20
            in 17..20 -> LightRed20
            else -> Color.Transparent
        }
    }
}