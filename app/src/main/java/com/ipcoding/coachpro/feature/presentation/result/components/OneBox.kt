package com.ipcoding.coachpro.feature.presentation.result.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun OneBox(
    modifier: Modifier,
    showText: Boolean,
    text:String,
    style: TextStyle
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if(showText)
            Text(
                text = text,
                color = AppTheme.colors.primary,
                style = style,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
    }
}