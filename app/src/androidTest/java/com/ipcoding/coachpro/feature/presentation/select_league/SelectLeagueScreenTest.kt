package com.ipcoding.coachpro.feature.presentation.select_league

import androidx.activity.compose.BackHandler
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.di.AppModule
import com.ipcoding.coachpro.feature.presentation.MainActivity
import com.ipcoding.coachpro.feature.presentation.choose_jersey.ChooseJerseyScreen
import com.ipcoding.coachpro.feature.presentation.select_club.SelectClubScreen
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
class SelectLeagueScreenTest {

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
                    startDestination = Screen.SelectLeagueScreen.route
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
                }
            }
        }
    }

    @Test
    fun testingRouteToChooseJerseyScreen_isCorrect() {

        composeRule.onNodeWithText("League 1").performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(
                Screen.SelectClubScreen.route
            )
        ).isTrue()

        composeRule.onNodeWithText("Bayern Munich").performClick()

        assertThat(
            navController.currentDestination?.route?.startsWith(
                Screen.ChooseJerseyScreen.route
            )
        ).isTrue()
    }
}