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
fun Jersey4(jerseyColors: JerseyColors) {
    Canvas(
        Modifier.fillMaxSize()
    ) {

        val width = size.width

        val clipPath = jerseyShape(width)

        clipPath(clipPath) {
            drawRoundRect(
                color = jerseyColors.colorJersey,
                size = Size(width, width.times(1.1071f))
            )
            drawRect(
                topLeft = Offset(0f, width.times(0.1582f)),
                color = jerseyColors.colorStripes,
                size = Size(width, width.times(0.1582f))
            )
            drawRect(
                topLeft = Offset(0f, width.times(0.4745f)),
                color = jerseyColors.colorStripes,
                size = Size(width, width.times(0.1582f))
            )
            drawRect(
                topLeft = Offset(0f, width.times(0.7908f)),
                color = jerseyColors.colorStripes,
                size = Size(width, width.times(0.1582f))
            )
            drawArc(
                color = jerseyColors.colorJersey,
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