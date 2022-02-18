package com.ipcoding.coachpro.feature.presentation.main

import androidx.activity.compose.BackHandler
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.core.util.TestTags.BUTTON_CONFIRM_MAINSCREEN
import com.ipcoding.coachpro.core.util.TestTags.BUTTON_TABLE_MAINSCREEN
import com.ipcoding.coachpro.core.util.TestTags.BUTTON_TRANSFERS_MAINSCREEN
import com.ipcoding.coachpro.di.AppModule
import com.ipcoding.coachpro.feature.presentation.MainActivity
import com.ipcoding.coachpro.feature.presentation.history.HistoryScreen
import com.ipcoding.coachpro.feature.presentation.info.InfoScreen
import com.ipcoding.coachpro.feature.presentation.players.PlayersScreen
import com.ipcoding.coachpro.feature.presentation.schedule.ScheduleScreen
import com.ipcoding.coachpro.feature.presentation.table.TableScreen
import com.ipcoding.coachpro.feature.presentation.tactics.TacticsScreen
import com.ipcoding.coachpro.feature.presentation.transfers.TransfersScreen
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.CoachProTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class MainScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            CoachProTheme {
                navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.MainScreen.route
                ) {
                    composable(route = Screen.InfoScreen.route) {
                        InfoScreen(navController = navController)
                        BackHandler(true) {}
                    }
                    composable(route = Screen.MainScreen.route) {
                        MainScreen(navController = navController)
                        BackHandler(true) {}
                    }
                    composable(route = Screen.PlayersScreen.route) {
                        PlayersScreen()
                        BackHandler(true) {}
                    }
                    composable(
                        route = Screen.TacticsScreen.route + "?nextIsMatch={nextIsMatch}",
                        arguments = listOf(
                            navArgument(name = "nextIsMatch") {
                                type = NavType.StringType
                                defaultValue = ""
                            }
                        )
                    ) {
                        val nextIsMatch = it.arguments?.getString("nextIsMatch") ?: ""
                        TacticsScreen(
                            navController = navController,
                            nextIsMatch = nextIsMatch
                        )
                        BackHandler(true) {}
                    }
                    composable(
                        route = Screen.ScheduleScreen.route + "?roundNumber={roundNumber}",
                        arguments = listOf(
                            navArgument(name = "roundNumber") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        val roundNumber = it.arguments?.getInt("roundNumber") ?: -1
                        ScheduleScreen(roundNumber = roundNumber)
                        BackHandler(true) {}
                    }
                    composable(route = Screen.HistoryScreen.route) {
                        HistoryScreen()
                        BackHandler(true) {}
                    }
                    composable(route = Screen.TransfersScreen.route) {
                        TransfersScreen()
                        BackHandler(true) {}
                    }
                    composable(route = Screen.TableScreen.route) {
                        TableScreen()
                        BackHandler(true) {}
                    }
                }
            }
        }
    }

    @Test
    fun squadButton_isCorrect() {

        composeRule.onNodeWithText("Squad").performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(
                Screen.PlayersScreen.route
            )
        ).isTrue()
    }

    @Test
    fun tacticsButton_isCorrect() {

        composeRule.onNodeWithText("Tactics").performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(Screen.TacticsScreen.route)
        ).isTrue()
    }

    @Test
    fun scheduleButton_isCorrect() {

        composeRule.onNodeWithText("Schedule").performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(Screen.ScheduleScreen.route)
        ).isTrue()
    }

    @Test
    fun historyButton_isCorrect() {

        composeRule.onNodeWithText("History").performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(Screen.HistoryScreen.route)
        ).isTrue()
    }

    @Test
    fun transfersButton_isCorrect() {

        composeRule.onNodeWithTag(BUTTON_TRANSFERS_MAINSCREEN).performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(Screen.TransfersScreen.route)
        ).isTrue()
    }

    @Test
    fun tableButton_isCorrect() {

        composeRule.onNodeWithTag(BUTTON_TABLE_MAINSCREEN).performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(Screen.TableScreen.route)
        ).isTrue()
    }

    @Test
    fun confirmButton_isCorrect() {

        composeRule.onNodeWithTag(BUTTON_CONFIRM_MAINSCREEN).performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(Screen.InfoScreen.route)
        ).isTrue()
    }
}