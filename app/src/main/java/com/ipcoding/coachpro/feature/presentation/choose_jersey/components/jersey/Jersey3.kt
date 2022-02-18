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
fun Jersey3(jerseyColors: JerseyColors) {
    Canvas(
        Modifier.fillMaxSize()
    ) {

        val width = size.width

        val clipPath = jerseyShape(width)

        clipPath(clipPath) {
            drawRoundRect(
                color = jerseyColors.colorJersey,
                size = Size(width.times(0.5f), width.times(1.1071f))
            )
            drawRoundRect(
                color = jerseyColors.colorStripes,
                size = Size(width.times(0.5f), width.times(1.1071f)),
                topLeft = Offset(width.times(0.5f), 0f)
            )
            drawArc(
                color = jerseyColors.colorStripes,
                startAngle = 90f,
                sweepAngle = 165f,
                useCenter = true,
                size = Size(width.times(0.4572f), width.times(0.8428f))
            )
            drawArc(
                color = jerseyColors.colorJersey,
                startAngle = 285f,
                sweepAngle = 165f,
                useCenter = true,
                size = Size(width.times(0.4572f), width.times(0.8428f)),
                topLeft = Offset(width.times(0.5428f), 0f)
            )
        }

        drawPath(path = clipPath, color = jerseyColors.colorBorder, style = Stroke(width = 3f))
    }
}