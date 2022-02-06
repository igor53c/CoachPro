package com.ipcoding.coachpro.feature.presentation.table.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
                    color = MaterialTheme.colors.primary
                ),
                shape = RoundedCornerShape(corner = CornerSize(AppTheme.dimens.spaceSmall))
            )
            .background(
                color = color,
                shape = RoundedCornerShape(corner = CornerSize(AppTheme.dimens.spaceSmall))
            )
            .padding(AppTheme.dimens.spaceSmall)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            maxLines = 1,
            text = club.name,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body2,
            modifier = Modifier
                .weight(1f)
        )

        Text(
            text = text1.value,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimens.spaceExtraMedium)
        )
        Text(
            text = text2.value,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimens.spaceExtraMedium)
        )
        Text(
            text = text3.value,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimens.spaceExtraMedium)
        )
        Text(
            text = club.points.toString(),
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimens.spaceExtraMedium)
        )
    }
}