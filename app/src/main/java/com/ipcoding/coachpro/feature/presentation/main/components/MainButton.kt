package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun MainButton(
    rowOne: String,
    rowTwo: String,
    colorText: Color,
    background: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    CustomButton(
        modifier = modifier,
        color = background,
        border = BorderStroke(
            width = AppTheme.dimensions.spaceSuperSmall,
            color = colorText
        ),
        contentColor = colorText,
        onClick = { onClick() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = rowOne,
                style = AppTheme.typography.body1
            )
            Text(
                text = rowTwo,
                style = AppTheme.typography.h5
            )
        }
    }
}