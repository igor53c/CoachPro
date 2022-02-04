package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import com.ipcoding.coachpro.core.util.Colors

@Composable
fun FootballField(
    colorLinie: Color
) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val clipPath = Path().apply {
            lineTo(size.width, 0f)
            lineTo(size.width , size.width * 1.1071f)
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
                color = colorLinie,
                size = Size(size.width * 0.5f, size.width * 0.25f),
                style = Stroke(width = 3f)
            )
            drawRect(
                topLeft = Offset(size.width * 0.4f, 0f),
                color = colorLinie,
                size = Size(size.width * 0.2f, size.width * 0.08f),
                style = Stroke(width = 3f)
            )
            drawCircle(
                color = colorLinie,
                radius = 5f,
                center = Offset(size.width * 0.5f, size.width * 0.16f)
            )
            drawCircle(
                color = colorLinie,
                radius = 20f,
                center = Offset(0f, 0f),
                style = Stroke(width = 3f)
            )
            drawCircle(
                color = colorLinie,
                radius = 20f,
                center = Offset(size.width, 0f),
                style = Stroke(width = 3f)
            )
            drawCircle(
                color = colorLinie,
                radius = size.width * 0.12f,
                center = Offset(size.width * 0.5f, size.width * 1.1071f),
                style = Stroke(width = 3f)
            )
            drawCircle(
                color = colorLinie,
                radius = 7f,
                center = Offset(size.width * 0.5f, size.width * 1.1071f)
            )
            drawArc(
                color = colorLinie,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = Offset(size.width * 0.425f, size.width * 0.2f),
                size = Size(size.width * 0.15f, size.width * 0.10f),
                style = Stroke(width = 3f)
            )

            drawPath(path = clipPath, color = colorLinie, style = Stroke(width = 5f))
        }
    }
}