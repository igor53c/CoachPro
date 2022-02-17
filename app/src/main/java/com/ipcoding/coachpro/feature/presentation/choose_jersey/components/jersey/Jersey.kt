package com.ipcoding.coachpro.feature.presentation.choose_jersey.components.jersey

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Jersey(
    colorJersey: Color,
    colorStripes: Color,
    colorBorder: Color,
    numberJersey: Int
) {
    when(numberJersey) {
        1 -> {
            Jersey1(
                colorJersey = colorJersey,
                colorStripes = colorStripes,
                colorBorder = colorBorder
            )
        }
        2 -> {
            Jersey2(
                colorJersey = colorJersey,
                colorStripes = colorStripes,
                colorBorder = colorBorder
            )
        }
        3 -> {
            Jersey3(
                colorJersey = colorJersey,
                colorStripes = colorStripes,
                colorBorder = colorBorder
            )
        }
        4 -> {
            Jersey4(
                colorJersey = colorJersey,
                colorStripes = colorStripes,
                colorBorder = colorBorder
            )
        }
        5 -> {
            Jersey5(
                colorJersey = colorJersey,
                colorStripes = colorStripes,
                colorBorder = colorBorder
            )
        }
    }
}