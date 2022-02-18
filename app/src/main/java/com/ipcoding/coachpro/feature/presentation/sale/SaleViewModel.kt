package com.ipcoding.coachpro.feature.presentation.sale

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import com.ipcoding.coachpro.feature.presentation.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaleViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
) : ViewModel() {

    private val _player = mutableStateOf(Player("", "", 0.0, 0, 0))
    val player: State<Player> = _player

    init {
        saveDestinationScreen()
        getRandomPlayer()
    }

    private fun saveDestinationScreen() {
        preferences.saveDestinationScreen(destinationScreen = Screen.MainScreen.route)
    }

    private fun getRandomPlayer() {
        viewModelScope.launch {
            allUseCases.randomPlayer()?.let {
                _player.value = it
            }
        }
    }

    fun saveBudget(value: Float) {
        preferences.saveBudget(preferences.loadBudget() + value)
    }

    fun getColor(position: String): Color {
        return allUseCases.getColorDependingOnPosition(position)
    }

    fun valueString(value: Float): String {
        return allUseCases.valueString(value)
    }

    fun deletePlayer(player: Player) {
        viewModelScope.launch {
            allUseCases.deletePlayer(player)
        }
    }
}