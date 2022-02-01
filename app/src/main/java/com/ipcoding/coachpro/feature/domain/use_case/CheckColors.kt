package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color

class CheckColors {

    operator fun invoke(colorJersey: Color, colorStripes: Color): Color {
        if(colorJersey == colorStripes) {
            if(colorJersey == Color.Black) return Color.White else return Color.Black
        } else return colorStripes
    }
}