package com.ipcoding.coachpro.feature.presentation.transfers.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun TransferConfirmation (
    budget: Float,
    player: Player,
    color: Color,
    onCancelClick: () -> Unit,
    onBuyClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Column(
                modifier = Modifier.padding(bottom = AppTheme.dimensions.spaceSmall)
            ) {
                if(budget >= player.value) {
                    CustomText(
                        text = player.name,
                        style = AppTheme.typography.h6,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    TransferConfirmationRow(
                        textPosition = stringResource(id = R.string.pos),
                        textRating = stringResource(id = R.string.rating),
                        textAge = stringResource(id = R.string.age),
                        textValue = stringResource(id = R.string.meuro)
                    )
                    TransferConfirmationRow(
                        textPosition = player.position,
                        textRating = String.format("%.1f", player.rating),
                        textAge = player.age.toString(),
                        textValue = String.format("%.1f", player.value),
                        color = color
                    )
                } else {
                    CustomText(
                        text = stringResource(id = R.string.enough_money),
                        style = AppTheme.typography.subtitle1,
                        maxLines = 5,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(bottom = AppTheme.dimensions.spaceSmall)
                            .fillMaxWidth()
                    )
                }
            }
        },
        confirmButton = {
            Row(
                modifier = Modifier
                    .padding(bottom = AppTheme.dimensions.spaceExtraSmall)
                    .height(AppTheme.dimensions.spaceLarge)
                    .fillMaxWidth(),
            ) {
                if(budget >= player.value) {
                    CustomButton(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        onClick = onBuyClick
                    ) {
                        Text(
                            text = stringResource(id = R.string.buy),
                            style = AppTheme.typography.body1
                        )
                    }

                    Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSmall))

                    CustomButton(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        onClick = onCancelClick
                    ) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            style = AppTheme.typography.body1
                        )
                    }
                } else {
                    CustomButton(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        onClick = onCancelClick
                    ) {
                        Text(
                            text = stringResource(id = R.string.ok),
                            style = AppTheme.typography.body1
                        )
                    }
                }
            }
        }
    )
}