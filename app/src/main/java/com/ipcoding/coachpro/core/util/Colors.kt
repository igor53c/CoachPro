package com.ipcoding.coachpro.core.util

import androidx.compose.ui.graphics.Color

class Colors {
    companion object {
        val Orange = Color(0xFFFF9800)
        val Navy = Color(0xFF000080)
        val Purple = Color(0xFF6200EE)
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