package com.ipcoding.coachpro.feature.presentation.choose_jersey.components.jersey

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import com.ipcoding.coachpro.feature.domain.util.JerseyColors

@Composable
fun Jersey6(jerseyColors: JerseyColors) {
    Canvas(
        Modifier.fillMaxSize()
    ) {

        val width = size.width

        val stripePath = Path().apply {
            moveTo(width.times(0.2357f), width.times(1.0714f))
            lineTo(width.times(0.05f), width.times(1.0714f))
            lineTo(width.times(0.7143f), 0f)
            lineTo(width.times(0.90f), 0f)
            close()
        }

        val clipPath = jerseyShape(width)

        clipPath(clipPath) {
            drawRoundRect(
                color = jerseyColors.colorJersey,
                size = Size(width, width.times(1.1071f))
            )
            drawPath(path = stripePath, color = jerseyColors.colorStripes)
        }

        drawPath(path = clipPath, color = jerseyColors.colorBorder, style = Stroke(width = 3f))
    }
}