package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun RatingText(
    title: String,
    modifier: Modifier = Modifier
) {
    CustomButton(
        modifier = modifier,
        color = AppTheme.colors.background,
        contentColor = AppTheme.colors.primary,
        shape = AppTheme.customShapes.rectangleShape
    ) {
        Text(
            text = title,
            style = AppTheme.typography.body1,
            color = AppTheme.colors.primary
        )
    }
}