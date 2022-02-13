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

    private val _numberOfPlayers = mutableStateOf(0)
    val numberOfPlayers: State<Int> = _numberOfPlayers

    private var getPlayersJob: Job? = null

    init {
        getPlayers()
        getNumberOfPlayers()
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
        _numberOfPlayers.value += 1
        viewModelScope.launch {
            allUseCases.updatePlayer(player)
        }
    }

    fun getNumberOfPlayers() {
        viewModelScope.launch {
            _numberOfPlayers.value = allUseCases.getNumberOfPlayers()
        }
    }
}