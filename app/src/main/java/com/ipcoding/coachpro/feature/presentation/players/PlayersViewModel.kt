package com.ipcoding.coachpro.feature.presentation.players

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val allUseCases: AllUseCases
): ViewModel() {

    private var _players = mutableStateOf<List<Player>>(emptyList())
    val players: State<List<Player>> = _players

    init {
        getPlayers()
    }

    fun getColor(position: String): Color {
        return allUseCases.getColorDependingOnPosition.invoke(position)
    }

    private fun getPlayers() {
        viewModelScope.launch {
            _players.value = allUseCases.getPlayers.invoke()
        }
    }

    fun updatePlayer(player: Player) {
        viewModelScope.launch {
            allUseCases.updatePlayer(player)
        }
    }
}