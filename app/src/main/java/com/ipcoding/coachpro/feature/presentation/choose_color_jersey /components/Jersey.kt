package com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath

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

        val width = size.width

        val clipPath = Path().apply {

            moveTo(width.times( 0.45f), width.times( 0.00857f))
            lineTo(width.times( 0.55f), width.times( 0.00857f))
            cubicTo(
                width.times( 0.6286f), 0f,
                width.times( 0.61f), 0f,
                width.times( 0.7071f), width.times(0.0643f) //1
            )
            cubicTo(
                width.times( 0.89f), width.times(0.1429f), //2
                width.times( 0.95f), width.times(0.2357f), //3
                width, width.times(0.46f)//4
            )
            lineTo(width, width.times(0.4929f)) //5
            lineTo(width.times(0.7929f), width.times(0.5214f)) //6
            lineTo(width.times(0.7714f), width.times(0.4214f)) //7
            cubicTo(
                width.times(0.7571f), width.times(0.4714f), //8
                width.times(0.7571f), width.times(0.5357f), //9
                width.times(0.7571f), width.times(0.6f) //10
            )
            lineTo(width.times(0.7643f), width.times(1.0714f)) //11
            cubicTo(
                width.times(0.5929f), width.times(1.1071f), //12
                width.times(0.4071f), width.times(1.1071f), //12
                width.times(0.2357f), width.times(1.0714f) //11
            )
            lineTo(width.times(0.2429f), width.times(0.6f)) //10
            cubicTo(
                width.times(0.2429f), width.times(0.5357f), //9
                width.times(0.2429f), width.times(0.4714f), //8
                width.times(0.2286f), width.times(0.4214f) //7
            )
            lineTo(width.times(0.2071f), width.times(0.5214f)) //6
            lineTo(0f, width.times(0.4929f)) //5
            lineTo(0f, width.times(0.46f)) //4
            cubicTo(
                width.times(0.05f), width.times(0.2357f), //3
                width.times(0.11f), width.times(0.1429f), //2
                width.times(0.2929f), width.times(0.0643f) //1
            )
            cubicTo(
                width.times( 0.39f), 0f,
                width.times( 0.3714f), 0f,
                width.times( 0.45f), width.times( 0.00857f)
            )
        }

        clipPath(clipPath) {
            drawRoundRect(
                color = colorJersey,
                size = Size(width, width.times(1.1071f))
            )
            drawRect(
                topLeft = Offset(width.times(0.45715f), 0f),
                color = colorStripes,
                size = Size(width.times(0.0857f), width.times( 1.1071f))
            )
            drawRect(
                topLeft = Offset(width.times( 0.28575f), 0f),
                color = colorStripes,
                size = Size(width.times( 0.0857f), width.times( 1.1071f))
            )
            drawRect(
                topLeft = Offset(width.times( 0.62855f), 0f),
                color = colorStripes,
                size = Size(width.times( 0.0857f), width.times( 1.1071f))
            )
        }

        drawPath(path = clipPath, color = colorBorder, style = Stroke(width = 3f))
    }

}