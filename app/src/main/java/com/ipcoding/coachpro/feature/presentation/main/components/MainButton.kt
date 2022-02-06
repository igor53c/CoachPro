package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun MainButton(
    rowOne: String,
    rowTwo: String,
    colorText: Color,
    background: Color
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.dimens.spaceExtraSmall)
            .border(
                border = BorderStroke(
                    width = AppTheme.dimens.spaceSuperSmall,
                    color = MaterialTheme.colors.onBackground
                ),
                shape = RoundedCornerShape(corner = CornerSize(AppTheme.dimens.spaceSmall))
            )
            .background(
                color = background,
                shape = RoundedCornerShape(corner = CornerSize(AppTheme.dimens.spaceSmall))
            )
            .padding(AppTheme.dimens.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = rowOne,
            color = colorText,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        Text(
            text = rowTwo,
            color = colorText,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
    }
}