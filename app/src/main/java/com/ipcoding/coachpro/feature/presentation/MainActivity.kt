package com.ipcoding.coachpro.feature.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipcoding.coachpro.feature.presentation.choose_color_jersey.ChooseColorJerseyScreen
import com.ipcoding.coachpro.feature.presentation.select_club.SelectClubScreen
import com.ipcoding.coachpro.feature.presentation.select_league.SelectLeagueScreen
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.CoachProTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoachProTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.SelectLeagueScreen.route
                    ) {
                        composable(route = Screen.SelectLeagueScreen.route) {
                            SelectLeagueScreen(navController = navController)
                        }
                        composable(route = Screen.SelectClubScreen.route) {
                            SelectClubScreen(navController = navController)
                        }
                        composable(route = Screen.ChooseColorJerseyScreen.route) {
                            ChooseColorJerseyScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

