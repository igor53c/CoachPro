package com.ipcoding.coachpro.feature.presentation.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.ipcoding.coachpro.R
import com.ipcoding.coachpro.feature.presentation.select_club.components.CustomButton
import com.ipcoding.coachpro.feature.presentation.table.components.CustomText
import com.ipcoding.coachpro.ui.theme.AppTheme

@Composable
fun NewGame(
    onNoClick: () -> Unit,
    onYesClick: () -> Unit
) {
    AlertDialog(
        backgroundColor = AppTheme.colors.primary,
        onDismissRequest = {},
        title = {
            Column(
                modifier = Modifier.padding(bottom = AppTheme.dimensions.spaceSmall)
            ) {
                Text(
                    text = stringResource(id = R.string.new_game),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = AppTheme.colors.background,
                    style = AppTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = AppTheme.dimensions.spaceSmall)
                        .fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Row(
                modifier = Modifier
                    .padding(bottom = AppTheme.dimensions.spaceExtraSmall)
                    .height(AppTheme.dimensions.spaceLarge)
                    .fillMaxWidth(),
            ) {

                CustomButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    onClick = onYesClick,
                    color = AppTheme.colors.background,
                    contentColor = AppTheme.colors.primary
                ) {
                    Text(
                        text = stringResource(id = R.string.yes),
                        style = AppTheme.typography.body1
                    )
                }

                Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSmall))

                CustomButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    onClick = onNoClick,
                    color = AppTheme.colors.background,
                    contentColor = AppTheme.colors.primary
                ) {
                    Text(
                        text = stringResource(id = R.string.no),
                        style = AppTheme.typography.body1
                    )
                }
            }
        }
    )
}