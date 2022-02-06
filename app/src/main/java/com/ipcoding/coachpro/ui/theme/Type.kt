package com.ipcoding.coachpro.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ipcoding.coachpro.R

/* Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )*/

)*/

private val appFontFamily = FontFamily(
    fonts = listOf(
        Font(R.font.montserrat_black),
        Font(R.font.montserrat_bold, weight = FontWeight.Bold),
        Font(R.font.montserrat_light, weight = FontWeight.Light),
        Font(R.font.montserrat_thin, weight = FontWeight.Thin),
        Font(R.font.montserrat_italic, weight = FontWeight.Normal, style = FontStyle.Italic)
    )
)

private val defaultTypography = Typography()

 val normalTypography = Typography(
    h1 = defaultTypography.h1.copy(fontFamily = appFontFamily),
    h2 = defaultTypography.h2.copy(fontFamily = appFontFamily),
    h3 = defaultTypography.h3.copy(fontFamily = appFontFamily),
    h4 = defaultTypography.h4.copy(fontFamily = appFontFamily),
    h5 = defaultTypography.h5.copy(fontFamily = appFontFamily),
    h6 = defaultTypography.h6.copy(fontFamily = appFontFamily),
    subtitle1 = defaultTypography.subtitle1.copy(fontFamily = appFontFamily),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = appFontFamily),
    body1 = defaultTypography.body1.copy(fontFamily = appFontFamily),
    body2 = defaultTypography.body2.copy(fontFamily = appFontFamily),
    button = defaultTypography.button.copy(fontFamily = appFontFamily),
    caption = defaultTypography.caption.copy(fontFamily = appFontFamily),
    overline = defaultTypography.overline.copy(fontFamily = appFontFamily)
)

val smallTypography = Typography(
    h1 = normalTypography.h1.copy(fontSize = 70.sp),
    h2 = normalTypography.h2.copy(fontSize = 50.sp),
    h3 = normalTypography.h3.copy(fontSize = 40.sp),
    h4 = normalTypography.h4.copy(fontSize = 30.sp),
    h5 = normalTypography.h5.copy(fontSize = 20.sp),
    h6 = normalTypography.h6.copy(fontSize = 16.sp),
    subtitle1 = normalTypography.subtitle1.copy(fontSize = 12.sp),
    subtitle2 = normalTypography.subtitle2.copy(fontSize = 10.sp),
    body1 = normalTypography.body1.copy(fontSize = 12.sp),
    body2 = normalTypography.body2.copy(fontSize = 10.sp),
    button = normalTypography.button.copy(fontSize = 10.sp),
    caption = normalTypography.caption.copy(fontSize = 8.sp),
    overline = normalTypography.overline.copy(fontSize = 6.sp)
)

val largeTypography = Typography(
    h1 = normalTypography.h1.copy(fontSize = 144.sp),
    h2 = normalTypography.h2.copy(fontSize = 90.sp),
    h3 = normalTypography.h3.copy(fontSize = 72.sp),
    h4 = normalTypography.h4.copy(fontSize = 48.sp),
    h5 = normalTypography.h5.copy(fontSize = 36.sp),
    h6 = normalTypography.h6.copy(fontSize = 30.sp),
    subtitle1 = normalTypography.subtitle1.copy(fontSize = 24.sp),
    subtitle2 = normalTypography.subtitle2.copy(fontSize = 21.sp),
    body1 = normalTypography.body1.copy(fontSize = 24.sp),
    body2 = normalTypography.body2.copy(fontSize = 21.sp),
    button = normalTypography.button.copy(fontSize = 21.sp),
    caption = normalTypography.caption.copy(fontSize = 18.sp),
    overline = normalTypography.overline.copy(fontSize = 15.sp)
)

val extraLargeTypography = Typography(
    h1 = normalTypography.h1.copy(fontSize = 192.sp),
    h2 = normalTypography.h2.copy(fontSize = 120.sp),
    h3 = normalTypography.h3.copy(fontSize = 96.sp),
    h4 = normalTypography.h4.copy(fontSize = 64.sp),
    h5 = normalTypography.h5.copy(fontSize = 48.sp),
    h6 = normalTypography.h6.copy(fontSize = 40.sp),
    subtitle1 = normalTypography.subtitle1.copy(fontSize = 32.sp),
    subtitle2 = normalTypography.subtitle2.copy(fontSize = 28.sp),
    body1 = normalTypography.body1.copy(fontSize = 32.sp),
    body2 = normalTypography.body2.copy(fontSize = 28.sp),
    button = normalTypography.button.copy(fontSize = 28.sp),
    caption = normalTypography.caption.copy(fontSize = 24.sp),
    overline = normalTypography.overline.copy(fontSize = 20.sp)
)