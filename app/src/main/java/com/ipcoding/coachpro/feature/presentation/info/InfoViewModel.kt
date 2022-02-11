package com.ipcoding.coachpro.feature.presentation.info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import com.ipcoding.coachpro.feature.domain.util.WeekType
import com.ipcoding.coachpro.feature.presentation.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
): ViewModel() {

    private var _week = mutableStateOf(0)

    private var _info = mutableStateOf<WeekType?>(null)
    val info: State<WeekType?> = _info

    init {
        saveDestinationScreen()
        loadWeek()
        getInfoText()
    }

    private fun saveDestinationScreen() {
        preferences.saveDestinationScreen(destinationScreen = Screen.InfoScreen.route)
    }

    fun preparationOfClubsAndScheduling() {
        viewModelScope.launch {
            allUseCases.preparationOfClubsAndScheduling
                .invoke(preferences.loadSelectedLeague().toString())
        }
    }

    private fun getInfoText() {
        viewModelScope.launch {
            _info.value = allUseCases.getWeekTypeText.invoke(_week.value, true)
        }
    }

    private fun loadWeek() {
        _week.value = preferences.loadWeek()
    }
}