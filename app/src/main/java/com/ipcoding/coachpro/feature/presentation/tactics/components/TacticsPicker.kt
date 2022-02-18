package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.feature.presentation.tactics.TacticsViewModel
import com.ipcoding.coachpro.ui.theme.AppTheme

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
    ) {
        items(allTactics.size) { item ->
            val currentTactics = allTactics[item][0]
            if (tactics[0] != currentTactics) {
                colorText.value = AppTheme.colors.primary
                colorTextBackground.value = AppTheme.colors.background
            } else {
                colorText.value = AppTheme.colors.background
                colorTextBackground.value = AppTheme.colors.primary
            }
            Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSmall))
            Text(
                text = currentTactics.toString(),
                style = AppTheme.typography.body1,
                color = colorText.value,
                modifier = Modifier
                    .clickable {
                        viewModel.saveTactics(allTactics[item])
                    }
                    .background(
                        color = colorTextBackground.value,
                        shape = AppTheme.customShapes.roundedCornerShape
                    )
                    .border(
                        border = BorderStroke(
                            width = AppTheme.dimensions.spaceSuperSmall,
                            color = AppTheme.colors.primary
                        ),
                        shape = AppTheme.customShapes.roundedCornerShape
                    )
                    .padding(AppTheme.dimensions.spaceSmall),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSmall))
        }
    }
}