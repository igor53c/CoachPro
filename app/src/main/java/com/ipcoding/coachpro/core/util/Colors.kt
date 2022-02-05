package com.ipcoding.coachpro.core.util

import androidx.compose.ui.graphics.Color

class Colors {
    companion object {
        private val Orange = Color(0xFFFF9800)
        private val Navy = Color(0xFF000080)
        private val Purple = Color(0xFF6200EE)
        val LightGreen10 = Color(0xFFC2FDC2)
        val LightGreen20 = Color(0xFFACFAAC)
        val LightBlue = Color(0xFFC5C5FF)
        val LightYellow = Color(0xFFF3F3BD)
        val LightRed10 = Color(0xFFFDC8C8)
        val LightRed20 = Color(0xFFF7A8A8)
        val LightGray10 = Color(0xFFAFADAD)
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