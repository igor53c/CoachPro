package com.ipcoding.coachpro.feature.presentation.result.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

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
            OneText(
                text = text,
                style = style
            )
    }
}