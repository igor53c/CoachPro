package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ipcoding.coachpro.feature.domain.util.FormMatch
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun FormMatches(
    formMatches: List<FormMatch>
) {
    val maxWidth = remember { mutableStateOf(0.dp) }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppTheme.dimensions.spaceSmall),
        contentAlignment = Alignment.TopCenter
    ) {

        maxWidth.value = this.maxWidth / 10

        LazyRow(horizontalArrangement = Arrangement.Center) {
            items(formMatches.size) { item ->

                CustomText(
                    text = formMatches[item].text,
                    style = AppTheme.typography.h6,
                    backgroundColor = formMatches[item].color,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(maxWidth.value)
                        .height(maxWidth.value)
                )
            }
        }
    }
}