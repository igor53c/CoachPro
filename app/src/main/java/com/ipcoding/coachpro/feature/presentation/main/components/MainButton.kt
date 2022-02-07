package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
            .padding(AppTheme.dimensions.spaceExtraSmall)
            .border(
                border = BorderStroke(
                    width = AppTheme.dimensions.spaceSuperSmall,
                    color = AppTheme.colors.onBackground
                ),
                shape = AppTheme.shapes.medium
            )
            .background(
                color = background,
                shape = AppTheme.shapes.medium
            )
            .padding(AppTheme.dimensions.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = rowOne,
            color = colorText,
            style = AppTheme.typography.body1,
            textAlign = TextAlign.Center
        )
        Text(
            text = rowTwo,
            color = colorText,
            style = AppTheme.typography.h5,
            textAlign = TextAlign.Center
        )
    }
}