package com.ipcoding.coachpro.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.ChooseColorJerseyScreen
import com.ipcoding.coachpro.feature.presentation.main.MainScreen
import com.ipcoding.coachpro.feature.presentation.table.TableScreen
import com.ipcoding.coachpro.feature.presentation.players.PlayersScreen
import com.ipcoding.coachpro.feature.presentation.select_club.SelectClubScreen
import com.ipcoding.coachpro.feature.presentation.select_league.SelectLeagueScreen
import com.ipcoding.coachpro.feature.presentation.tactics.TacticsScreen
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.CoachProTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowSelectScreen = preferences.loadClubName()
        setContent {
            CoachProTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = if(shouldShowSelectScreen == null) {
                            Screen.SelectLeagueScreen.route
                        } else Screen.MainScreen.route
                    ) {
                        composable(route = Screen.SelectLeagueScreen.route) {
                            SelectLeagueScreen(navController = navController)
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
                        }
                        composable(route = Screen.TableScreen.route) {
                            TableScreen(navController = navController)
                        }
                        composable(route = Screen.TacticsScreen.route) {
                            TacticsScreen()
                        }
                    }
                }
            }
        }
    }
}

