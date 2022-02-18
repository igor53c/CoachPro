package com.ipcoding.coachpro.feature.presentation.choose_jersey.components.jersey

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import com.ipcoding.coachpro.feature.domain.util.JerseyColors

@Composable
fun Jersey1(jerseyColors: JerseyColors) {
    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        val width = size.width

        val clipPath = jerseyShape(width)

        clipPath(clipPath) {
            drawRoundRect(
                color = jerseyColors.colorJersey,
                size = Size(width, width.times(1.1071f))
            )
            drawRect(
                topLeft = Offset(width.times(0.45715f), 0f),
                color = jerseyColors.colorStripes,
                size = Size(width.times(0.0857f), width.times(1.1071f))
            )
            drawRect(
                topLeft = Offset(width.times(0.28575f), 0f),
                color = jerseyColors.colorStripes,
                size = Size(width.times(0.0857f), width.times(1.1071f))
            )
            drawRect(
                topLeft = Offset(width.times(0.62855f), 0f),
                color = jerseyColors.colorStripes,
                size = Size(width.times(0.0857f), width.times(1.1071f))
            )
        }

        drawPath(path = clipPath, color = jerseyColors.colorBorder, style = Stroke(width = 3f))
    }
}