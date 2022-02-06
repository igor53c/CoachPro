package com.ipcoding.coachpro.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp



class Dimensions(
    val spaceSuperSmall: Dp = 2.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceExtraMedium: Dp = 32.dp,
    val spaceLarge: Dp = 48.dp,
    val spaceExtraLarge: Dp = 64.dp,
    val spaceSuperLarge: Dp = 96.dp
)
val normalDimensions = Dimensions()

val smallDimensions = Dimensions(
    spaceExtraSmall = 2.dp,
    spaceSmall = 4.dp,
    spaceMedium = 8.dp,
    spaceExtraMedium = 16.dp,
    spaceLarge = 32.dp,
    spaceExtraLarge = 48.dp,
    spaceSuperLarge = 64.dp
)

val largeTDimensions = Dimensions(
    spaceSuperSmall = 3.dp,
    spaceExtraSmall = 6.dp,
    spaceSmall = 12.dp,
    spaceMedium = 24.dp,
    spaceExtraMedium = 40.dp,
    spaceLarge = 56.dp,
    spaceExtraLarge = 80.dp,
    spaceSuperLarge = 112.dp
)

val extraLargeDimensions = Dimensions(
    spaceSuperSmall = 4.dp,
    spaceExtraSmall = 8.dp,
    spaceSmall = 16.dp,
    spaceMedium = 32.dp,
    spaceExtraMedium = 48.dp,
    spaceLarge = 64.dp,
    spaceExtraLarge = 96.dp,
    spaceSuperLarge = 128.dp
)