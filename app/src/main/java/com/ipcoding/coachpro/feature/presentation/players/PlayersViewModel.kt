package com.ipcoding.coachpro.feature.presentation.players

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val allUseCases: AllUseCases
): ViewModel() {

    private val _players = mutableStateOf<List<Player>>(emptyList())
    val players: State<List<Player>> = _players

    private var getPlayersJob: Job? = null

    init {
        getPlayers()
    }

    fun getColor(position: String): Color {
        return allUseCases.getColorDependingOnPosition(position)
    }

    private fun getPlayers() {
        getPlayersJob?.cancel()
        getPlayersJob = allUseCases.getPlayers()
            .onEach { items ->
                _players.value = items
            }
            .launchIn(viewModelScope)
    }

    fun updatePlayer(player: Player) {
       viewModelScope.launch {
            allUseCases.updatePlayer(player)
        }
    }
}