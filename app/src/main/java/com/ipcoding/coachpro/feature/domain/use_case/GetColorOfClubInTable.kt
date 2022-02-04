package com.ipcoding.coachpro.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.core.util.Colors
import com.ipcoding.coachpro.feature.domain.model.Club

class GetColorOfClubInTable {

    operator fun invoke(club: Club, selectedClub: String): Color {
        var color = Color.Transparent
        if(club.name == selectedClub) {
            when(club.position) {
                in 1..4 -> color = Colors.LightGreen20
                in 5..16 -> color = Colors.LightGray10
                in 17..20 -> color = Colors.LightRed20
            }
        } else {
            when(club.position) {
                in 1..4 -> color = Colors.LightGreen10
                in 17..20 -> color = Colors.LightRed10
            }
        }
        return color
    }
}