package com.ipcoding.coachpro.feature.presentation.table.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    textAlign: TextAlign?,
    maxLines: Int = 1,
    backgroundColor: Color = Color.Transparent
) {
    Box(
        modifier = modifier
            .height(AppTheme.dimensions.spaceExtraMedium),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(AppTheme.dimensions.spaceSuperSmall)
                .background(
                    color = backgroundColor,
                    shape = AppTheme.shapes.medium
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis,
                color = AppTheme.colors.primary,
                style = style,
                textAlign = textAlign,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}