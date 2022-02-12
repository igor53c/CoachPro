package com.ipcoding.coachpro.feature.presentation.main

import androidx.activity.compose.BackHandler
import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ipcoding.coachpro.di.AppModule
import com.ipcoding.coachpro.feature.presentation.MainActivity
import com.ipcoding.coachpro.feature.presentation.choose_jersey.ChooseJerseyScreen
import com.ipcoding.coachpro.feature.presentation.info.InfoScreen
import com.ipcoding.coachpro.feature.presentation.players.PlayersScreen
import com.ipcoding.coachpro.feature.presentation.result.ResultScreen
import com.ipcoding.coachpro.feature.presentation.schedule.ScheduleScreen
import com.ipcoding.coachpro.feature.presentation.select_club.SelectClubScreen
import com.ipcoding.coachpro.feature.presentation.select_league.SelectLeagueScreen
import com.ipcoding.coachpro.feature.presentation.table.TableScreen
import com.ipcoding.coachpro.feature.presentation.tactics.TacticsScreen
import com.ipcoding.coachpro.feature.presentation.transfers.TransfersScreen
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme
import com.ipcoding.coachpro.ui.theme.CoachProTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule

@HiltAndroidTest
@UninstallModules(AppModule::class)
class MainScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            CoachProTheme {
                Surface(
                    color = AppTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainScreen.route
                    ) {
                        composable(route = Screen.SelectLeagueScreen.route) {
                            SelectLeagueScreen(navController = navController)
                            BackHandler(true) {}
                        }
                        composable(route = Screen.SelectClubScreen.route) {
                            SelectClubScreen(navController = navController)
                            BackHandler(true) {}
                        }
                        composable(route = Screen.ChooseJerseyScreen.route) {
                            ChooseJerseyScreen(navController = navController)
                            BackHandler(true) {}
                        }
                        composable(route = Screen.MainScreen.route) {
                            MainScreen(navController = navController)
                            BackHandler(true) {}
                        }
                        composable(route = Screen.PlayersScreen.route) {
                            PlayersScreen(navController = navController)
                            BackHandler(true) {}
                        }
                        composable(route = Screen.TableScreen.route) {
                            TableScreen(navController = navController)
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
                            ScheduleScreen(
                                navController = navController,
                                roundNumber = roundNumber
                            )
                            BackHandler(true) {}
                        }
                        composable(route = Screen.InfoScreen.route) {
                            InfoScreen(navController = navController)
                            BackHandler(true) {}
                        }
                        composable(route = Screen.TransfersScreen.route) {
                            TransfersScreen(navController = navController)
                            BackHandler(true) {}
                        }
                        composable(route = Screen.ResultScreen.route) {
                            ResultScreen(navController = navController)
                            BackHandler(true) {}
                        }
                    }
                }
            }
        }
    }
}