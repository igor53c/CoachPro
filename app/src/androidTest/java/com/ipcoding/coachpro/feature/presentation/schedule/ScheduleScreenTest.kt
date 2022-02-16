package com.ipcoding.coachpro.feature.presentation.schedule

import androidx.activity.compose.BackHandler
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.common.truth.Truth.assertThat
import com.ipcoding.coachpro.core.util.TestTags
import com.ipcoding.coachpro.di.AppModule
import com.ipcoding.coachpro.feature.presentation.MainActivity
import com.ipcoding.coachpro.feature.presentation.main.MainScreen
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
class ScheduleScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController
    private var roundNumber = 10

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            CoachProTheme {
                navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.ScheduleScreen.route
                ) {
                    composable(route = Screen.ScheduleScreen.route) {
                        ScheduleScreen(roundNumber = roundNumber)
                        BackHandler(true) {}
                    }
                    composable(route = Screen.MainScreen.route) {
                        MainScreen(navController = navController)
                        BackHandler(true) {}
                    }
                }
            }
        }
    }

    @Test
    fun checkIfSpecifiedRound_isVisible() {

        composeRule.onNodeWithText("Round 10").assertIsDisplayed()
    }

    @Test
    fun checkIfSpecifiedRound_scroll() {

        composeRule.onNodeWithTag(TestTags.LAZY_ROW_SCHEDULESCREEN).assert(hasScrollAction())
    }
}