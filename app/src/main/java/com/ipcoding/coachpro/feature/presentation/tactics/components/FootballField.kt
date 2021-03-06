package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.Dp
import com.ipcoding.coachpro.ui.theme.Colors

@Composable
fun FootballField(
    colorLine: Color,
    width: Dp
) {
    Canvas(
        modifier = Modifier
            .width(width)
    ) {

        val clipPath = Path().apply {
            lineTo(size.width, 0f)
            lineTo(size.width, size.width * 1.1071f)
            lineTo(0f, size.width * 1.1071f)
            close()
        }

        clipPath(clipPath) {
            drawRect(
                color = Colors.LightGreen10,
                size = Size(size.width, size.width * 1.1071f)
            )
            drawRect(
                topLeft = Offset(size.width * 0.25f, 0f),
                color = colorLine,
                size = Size(size.width * 0.5f, size.width * 0.25f),
                style = Stroke(width = 3f)
            )
            drawRect(
                topLeft = Offset(size.width * 0.4f, 0f),
                color = colorLine,
                size = Size(size.width * 0.2f, size.width * 0.08f),
                style = Stroke(width = 3f)
            )
            drawCircle(
                color = colorLine,
                radius = 5f,
                center = Offset(size.width * 0.5f, size.width * 0.16f)
            )
            drawCircle(
                color = colorLine,
                radius = 20f,
                center = Offset(0f, 0f),
                style = Stroke(width = 3f)
            )
            drawCircle(
                color = colorLine,
                radius = 20f,
                center = Offset(size.width, 0f),
                style = Stroke(width = 3f)
            )
            drawCircle(
                color = colorLine,
                radius = size.width * 0.12f,
                center = Offset(size.width * 0.5f, size.width * 1.1071f),
                style = Stroke(width = 3f)
            )
            drawCircle(
                color = colorLine,
                radius = 7f,
                center = Offset(size.width * 0.5f, size.width * 1.1071f)
            )
            drawArc(
                color = colorLine,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = Offset(size.width * 0.425f, size.width * 0.2f),
                size = Size(size.width * 0.15f, size.width * 0.10f),
                style = Stroke(width = 3f)
            )

            drawPath(path = clipPath, color = colorLine, style = Stroke(width = 5f))
        }
    }
}