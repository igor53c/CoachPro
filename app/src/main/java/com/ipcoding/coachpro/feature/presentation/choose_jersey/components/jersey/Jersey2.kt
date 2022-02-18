package com.ipcoding.coachpro.feature.presentation.choose_jersey.components.jersey

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import com.ipcoding.coachpro.feature.domain.util.JerseyColors

@Composable
fun Jersey2(jerseyColors: JerseyColors) {
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
            drawArc(
                color = jerseyColors.colorStripes,
                startAngle = 90f,
                sweepAngle = 165f,
                useCenter = true,
                size = Size(width.times(0.4572f), width.times(0.8428f))
            )
            drawArc(
                color = jerseyColors.colorStripes,
                startAngle = 285f,
                sweepAngle = 165f,
                useCenter = true,
                size = Size(width.times(0.4572f), width.times(0.8428f)),
                topLeft = Offset(width.times( 0.5428f), 0f)
            )
        }

        drawPath(path = clipPath, color = jerseyColors.colorBorder, style = Stroke(width = 3f))
    }
}