package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color

class CheckColors {

    operator fun invoke(colorJersey: Color, colorStripes: Color): Color {
        return if(colorJersey == colorStripes) {
            if(colorJersey == Color.Black)  Color.White else  Color.Black
        } else  colorStripes
    }
}