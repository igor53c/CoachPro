package com.ipcoding.coachpro.core.util

import androidx.compose.ui.graphics.Color

class Colors {
    companion object {
        private val Orange = Color(0xFFFF9800)
        private val Navy = Color(0xFF000080)
        private val Purple = Color(0xFF6200EE)
        val LightGreen10 = Color(0x1A00FF00)
        val LightGreen20 = Color(0x3300FF00)
        val LightBlue = Color(0x1A0000FF)
        val LightYellow = Color(0x1AFFFF00)
        val LightRed10 = Color(0x1AFF0000)
        val LightRed20 = Color(0x33FF0000)
        val LightGray10 = Color(0x1A000000)
        val ColorList = listOf(Color.Black, Color.LightGray, Color.Green,
            Color.Cyan, Color.Blue, Navy, Purple, Color.Magenta,
            Color.Red, Orange, Color.Yellow, Color.White)
    }

    fun colorToIndex (color: Color): Int {
        return ColorList.indexOf(color)
    }

    fun indexToColor (index: Int): Color {
        return ColorList[index]
    }
}