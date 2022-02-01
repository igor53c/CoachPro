package com.ipcoding.coachpro.feature.presentation.choose_color_jersey.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ipcoding.coachpro.core.util.Colors

@Composable
fun ColorPicker(
    onColorSelected: (Color) -> Unit
) {
    
    val colorList: List<Color> = Colors.ColorList
    
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