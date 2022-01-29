package com.ipcoding.coachpro.feature.presentation.util

sealed class Screen(val route: String) {

    object StartScreen: Screen("start_screen")
}