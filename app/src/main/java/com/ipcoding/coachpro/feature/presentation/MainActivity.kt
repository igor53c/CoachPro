package com.ipcoding.coachpro.feature.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.ChooseColorJerseyScreen
import com.ipcoding.coachpro.feature.presentation.info.InfoScreen
import com.ipcoding.coachpro.feature.presentation.main.MainScreen
import com.ipcoding.coachpro.feature.presentation.table.TableScreen
import com.ipcoding.coachpro.feature.presentation.players.PlayersScreen
import com.ipcoding.coachpro.feature.presentation.schedule.ScheduleScreen
import com.ipcoding.coachpro.feature.presentation.select_club.SelectClubScreen
import com.ipcoding.coachpro.feature.presentation.select_league.SelectLeagueScreen
import com.ipcoding.coachpro.feature.presentation.tactics.TacticsScreen
import com.ipcoding.coachpro.feature.presentation.transfers.TransfersScreen
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.AppTheme
import com.ipcoding.coachpro.ui.theme.CoachProTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowSelectScreen = preferences.loadYear()
        setContent {
            CoachProTheme {
                Surface(
                    color = AppTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = if(shouldShowSelectScreen == -1) {
                            Screen.SelectLeagueScreen.route
                        } else Screen.MainScreen.route
                    ) {
                        composable(route = Screen.SelectLeagueScreen.route) {
                            SelectLeagueScreen(navController = navController)
                            BackHandler(true) {}
                        }
                        composable(route = Screen.SelectClubScreen.route) {
                            SelectClubScreen(navController = navController)
                            BackHandler(true) {}
                        }
                        composable(route = Screen.ChooseColorJerseyScreen.route) {
                            ChooseColorJerseyScreen(navController = navController)
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
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            val nextIsMatch = it.arguments?.getInt("nextIsMatch") ?: -1
                            Log.d("nextIsMatch", "nextIsMatch: $nextIsMatch")
                            TacticsScreen(
                                navController = navController,
                                nextIsMatch = nextIsMatch
                            )
                            BackHandler(true) {}
                        }
                        composable(route = Screen.ScheduleScreen.route) {
                            ScheduleScreen(navController = navController)
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
                    }
                }
            }
        }
    }
}

