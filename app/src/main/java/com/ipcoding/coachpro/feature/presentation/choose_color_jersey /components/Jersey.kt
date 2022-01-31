package com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.sourceInformationMarkerStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils

@Composable
@Preview(showBackground = true)
fun Jersey(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        val clipPath = Path().apply {
            moveTo(size.width * 0.3714f, 0f)
            lineTo(size.width * 0.4357f, size.width * 0.02857f)
            lineTo(size.width - size.width * 0.4357f, size.width * 0.02857f)
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
            lineTo(size.width * 0.3714f, 0f)
        }

        clipPath(clipPath) {
            drawRoundRect(
                color = Color.Red,
                size = Size(size.width, size.height)
            )
            drawRect(
                topLeft = Offset(size.width * 0.45715f, 0f),
                color = Color.White,
                size = Size(size.width * 0.0857f, size.height)
            )
            drawRect(
                topLeft = Offset(size.width * 0.28575f, 0f),
                color = Color.White,
                size = Size(size.width * 0.0857f, size.height)
            )
            drawRect(
                topLeft = Offset(size.width * 0.62855f, 0f),
                color = Color.White,
                size = Size(size.width * 0.0857f, size.height)
            )
        }

        drawPath(path = clipPath, color = Color.Black, style = Stroke(width = 5f))
    }

}