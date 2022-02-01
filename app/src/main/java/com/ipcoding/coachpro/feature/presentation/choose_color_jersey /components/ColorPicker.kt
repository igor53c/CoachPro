package com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.core.util.NewColor

@Composable
fun ColorPicker(
    onColorSelected: (Color) -> Unit
) {
    
    val colorList: List<Color> = listOf(Color.Black, Color.LightGray, Color.Green,
        Color.Cyan, Color.Blue, NewColor.Navy, NewColor.Purple,
        Color.Magenta, Color.Red, NewColor.Orange, Color.Yellow, Color.White)
    
    LazyRow(horizontalArrangement = Arrangement.Center) {
        items(colorList.size) { item ->
            val color = colorList[item]
            OneColor(
                color = color,
                border = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .clickable {
                        onColorSelected.invoke(color)
                    }
            )
        }
    }
}