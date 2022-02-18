package com.ipcoding.coachpro.feature.presentation.transfers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransfersViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
): ViewModel() {

    private val _players = mutableStateOf<List<Player>>(emptyList())
    val players: State<List<Player>> = _players

    private var _week = mutableStateOf(0)
    val week: State<Int> = _week

    private var getPlayersJob: Job? = null

    init {
        getPlayers()
        loadWeek()
    }

    fun transferWindow() : Boolean {
        return allUseCases.transferWindow(week.value)
    }

    private fun loadWeek() {
        _week.value = preferences.loadWeek()
    }

    fun getColor(position: String): Color {
        return allUseCases.getColorDependingOnPosition(position)
    }

    fun getBudget() : Float {
        return preferences.loadBudget()
    }

    fun saveBudget(budget: Float) {
       preferences.saveBudget(budget)
    }

    private fun getPlayers() {
        getPlayersJob?.cancel()
        getPlayersJob = allUseCases.getTransferPlayers()
            .onEach { items ->
                _players.value = items
            }
            .launchIn(viewModelScope)
    }

    fun updatePlayer(player: Player) {
        viewModelScope.launch {
            player.transferPlayer = false
            player.number = allUseCases.getNumberOfPlayers() + 1
            allUseCases.updatePlayer(player)
        }
    }
}