package com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.dp

@Composable
fun Jersey(
    modifier: Modifier,
    colorJersey: Color,
    colorStripes: Color,
    colorBorder: Color
) {
    Canvas(
        modifier = modifier
    ) {

        val clipPath = Path().apply {
            moveTo(size.width * 0.3714f, 0f)
            lineTo(size.width * 0.39f, 0f)
            lineTo(size.width * 0.45f, size.width * 0.00857f)
            lineTo(size.width - size.width * 0.45f, size.width * 0.00857f)
            lineTo(size.width - size.width * 0.39f, 0f)
            lineTo(size.width - size.width * 0.3714f, 0f)
            lineTo(size.width * 0.7071f, size.width * 0.0643f)
            lineTo(size.width * 0.8714f, size.width * 0.1429f)
            lineTo(size.width * 0.9429f, size.width * 0.2357f)
            lineTo(size.width, size.width * 0.46f)
            lineTo(size.width, size.width * 0.4929f)
            lineTo(size.width * 0.7929f, size.width * 0.5214f)
            lineTo(size.width * 0.7714f, size.width * 0.4214f)
            lineTo(size.width * 0.7571f, size.width * 0.4714f)
            lineTo(size.width * 0.7571f, size.width * 0.5357f)
            lineTo(size.width * 0.7643f, size.width * 1.0714f)
            lineTo(size.width * 0.5929f, size.width * 1.1071f)
            lineTo(size.width - size.width * 0.5929f, size.width * 1.1071f)
            lineTo(size.width - size.width * 0.7643f, size.width * 1.0714f)
            lineTo(size.width - size.width * 0.7571f, size.width * 0.5357f)
            lineTo(size.width - size.width * 0.7571f, size.width * 0.4714f)
            lineTo(size.width - size.width * 0.7714f, size.width * 0.4214f)
            lineTo(size.width - size.width * 0.7929f, size.width * 0.5214f)
            lineTo(0f, size.width * 0.4929f)
            lineTo(0f, size.width * 0.46f)
            lineTo(size.width - size.width * 0.9429f, size.width * 0.2357f)
            lineTo(size.width - size.width * 0.8714f, size.width * 0.1429f)
            lineTo(size.width - size.width * 0.7071f, size.width * 0.0643f)
            close()
        }

        clipPath(clipPath) {
            drawRoundRect(
                color = colorJersey,
                size = Size(size.width, size.width * 1.1071f)
            )
            drawRect(
                topLeft = Offset(size.width * 0.45715f, 0f),
                color = colorStripes,
                size = Size(size.width * 0.0857f, size.width * 1.1071f)
            )
            drawRect(
                topLeft = Offset(size.width * 0.28575f, 0f),
                color = colorStripes,
                size = Size(size.width * 0.0857f, size.width * 1.1071f)
            )
            drawRect(
                topLeft = Offset(size.width * 0.62855f, 0f),
                color = colorStripes,
                size = Size(size.width * 0.0857f, size.width * 1.1071f)
            )
        }

        drawPath(path = clipPath, color = colorBorder, style = Stroke(width = 5f))
    }

}