package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ipcoding.coachpro.feature.presentation.tactics.TacticsViewModel

@Composable
fun TacticsPicker(
    allTactics: List<List<Any>>,
    colorText: MutableState<Color>,
    colorTextBackground: MutableState<Color>,
    tactics: List<Any>,
    viewModel: TacticsViewModel
) {
    LazyRow(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        items(allTactics.size) { item ->
            val currentTactics = allTactics[item][0]
            if(!tactics[0].equals(currentTactics)) {
                colorText.value = MaterialTheme.colors.primary
                colorTextBackground.value = MaterialTheme.colors.background
            } else {
                colorText.value = MaterialTheme.colors.background
                colorTextBackground.value = MaterialTheme.colors.primary
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = currentTactics.toString(),
                style = MaterialTheme.typography.h5,
                color = colorText.value,
                modifier = Modifier
                    .clickable {
                        viewModel.saveTactics(allTactics[item])
                    }
                    .background(
                        color = colorTextBackground.value,
                        shape = RoundedCornerShape(corner = CornerSize(10.dp))
                    )
                    .border(
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colors.primary
                        ),
                        shape = RoundedCornerShape(corner = CornerSize(10.dp))
                    )
                    .padding(8.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}