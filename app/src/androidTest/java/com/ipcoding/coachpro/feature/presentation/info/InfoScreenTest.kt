package com.ipcoding.coachpro.feature.presentation.info

import androidx.activity.compose.BackHandler
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipcoding.coachpro.core.data.resources.AndroidResourceProvider
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.di.AppModule
import com.ipcoding.coachpro.feature.data.repository.*
import com.ipcoding.coachpro.feature.domain.use_case.*
import com.ipcoding.coachpro.feature.presentation.MainActivity
import com.ipcoding.coachpro.feature.presentation.main.MainScreen
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.CoachProTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class InfoScreenTest {

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
                    startDestination = Screen.InfoScreen.route
                ) {
                    composable(route = Screen.InfoScreen.route) {
                        InfoScreen(navController = navController)
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
    fun continueButton_isCorrect() {

        composeRule.onNodeWithText("Continue").assertHasClickAction()
    }
}