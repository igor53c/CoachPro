package com.ipcoding.coachpro.feature.presentation.choose_jersey.components.jersey

import androidx.compose.runtime.Composable
import com.ipcoding.coachpro.feature.domain.util.JerseyColors

@Composable
fun Jersey(
    jerseyColors: JerseyColors,
    numberJersey: Int
) {
    when(numberJersey) {
        1 -> Jersey1(jerseyColors)
        2 -> Jersey2(jerseyColors)
        3 -> Jersey3(jerseyColors)
        4 -> Jersey4(jerseyColors)
        5 -> Jersey5(jerseyColors)
        6 -> Jersey6(jerseyColors)
    }
}