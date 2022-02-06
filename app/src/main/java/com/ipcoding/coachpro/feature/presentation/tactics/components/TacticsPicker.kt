package com.ipcoding.coachpro.feature.presentation.tactics.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
            .padding(
                top = AppTheme.dimens.spaceSmall,
                bottom = AppTheme.dimens.spaceSmall
            )
    ) {
        items(allTactics.size) { item ->
            val currentTactics = allTactics[item][0]
            if(tactics[0] != currentTactics) {
                colorText.value = MaterialTheme.colors.primary
                colorTextBackground.value = MaterialTheme.colors.background
            } else {
                colorText.value = MaterialTheme.colors.background
                colorTextBackground.value = MaterialTheme.colors.primary
            }
            Spacer(modifier = Modifier.width(AppTheme.dimens.spaceSmall))
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
                        shape = RoundedCornerShape(
                            corner = CornerSize(AppTheme.dimens.spaceSmall)
                        )
                    )
                    .border(
                        border = BorderStroke(
                            width = AppTheme.dimens.spaceSuperSmall,
                            color = MaterialTheme.colors.primary
                        ),
                        shape = RoundedCornerShape(
                            corner = CornerSize(AppTheme.dimens.spaceSmall)
                        )
                    )
                    .padding(AppTheme.dimens.spaceSmall),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(AppTheme.dimens.spaceSmall))
        }
    }
}