package com.ipcoding.coachpro.feature.presentation.table.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.ui.theme.AppTheme
import com.ipcoding.coachpro.ui.theme.Colors

@Composable
fun OneClub(
    club: Club,
    color: Color,
    isShowGoals: Boolean,
    clubName: String,
    modifier: Modifier = Modifier
) {
    val text1 = remember { mutableStateOf("") }
    val text2 = remember { mutableStateOf("") }
    val text3 = remember { mutableStateOf("") }
    val backgroundColor = remember { mutableStateOf(Color.Transparent) }

    if(clubName == club.name) backgroundColor.value = Colors.LightGray10

    if(!isShowGoals) {
        text1.value = club.win.toString()
        text2.value = club.draw.toString()
        text3.value = club.lose.toString()
    } else {
        text1.value = club.goalsFor.toString()
        text2.value = club.goalsAgainst.toString()
        text3.value = club.goalDifference.toString()
    }
    Row(
        modifier = modifier
            .background(color = backgroundColor.value)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomText(
            text = club.position.toString(),
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Center,
            backgroundColor = color,
            modifier = Modifier
                .padding(start = AppTheme.dimensions.spaceSmall)
                .width(AppTheme.dimensions.spaceExtraMedium)
        )
        CustomText(
            text = club.name,
            style = AppTheme.typography.body2,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = AppTheme.dimensions.spaceExtraSmall)
                .weight(1f)
        )

        ClubInfo(
            text1 = text1.value,
            text2 = text2.value,
            text3 = text3.value,
            pointsText = club.points.toString()
        )
    }
}