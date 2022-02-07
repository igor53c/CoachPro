package com.ipcoding.coachpro.feature.presentation.table.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun OneClub(
    club: Club,
    color: Color,
    isShowGoals: Boolean
) {
    val text1 = remember { mutableStateOf("") }
    val text2 = remember { mutableStateOf("") }
    val text3 = remember { mutableStateOf("") }
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
        modifier = Modifier
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = AppTheme.colors.primary
                ),
                shape = AppTheme.shapes.medium
            )
            .background(
                color = color,
                shape = AppTheme.shapes.medium
            )
            .padding(AppTheme.dimensions.spaceSmall)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            maxLines = 1,
            text = club.name,
            color = AppTheme.colors.primary,
            style = AppTheme.typography.body2,
            modifier = Modifier
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