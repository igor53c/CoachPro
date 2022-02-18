package com.ipcoding.coachpro.feature.presentation.tactics

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.util.InputData.ALL_TACTICS
import com.ipcoding.coachpro.feature.domain.util.MarkedPlayer
import com.ipcoding.coachpro.feature.domain.model.Player
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import com.ipcoding.coachpro.feature.domain.util.JerseyColors
import com.ipcoding.coachpro.feature.presentation.util.Screen
import com.ipcoding.coachpro.ui.theme.Colors
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TacticsViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
) : ViewModel() {

    private var _jerseyColors = mutableStateOf(JerseyColors())
    val jerseyColors: State<JerseyColors> = _jerseyColors

    private var _tactics = mutableStateOf<List<Any>>(mutableListOf())
    val tactics: State<List<Any>> = _tactics

    private var _allTactics = mutableStateOf<List<List<Any>>>(mutableListOf())
    val allTactics: State<List<List<Any>>> = _allTactics

    private val _players = mutableStateOf<List<Player>>(emptyList())
    val players: State<List<Player>> = _players

    private var _previouslyClickedInfo = mutableStateOf(MarkedPlayer())
    val previouslyClickedInfo: State<MarkedPlayer> = _previouslyClickedInfo

    private var _numberJersey = mutableStateOf(1)
    val numberJersey: State<Int> = _numberJersey

    private var getPlayersJob: Job? = null

    init {
        getPlayers()
        loadColorJersey()
        loadColorStripes()
        loadTactics()
        loadAllTactics()
        loadNumberJersey()
    }

    private fun loadNumberJersey() {
        _numberJersey.value = preferences.loadNumberJersey()
    }

    fun saveNextDestinationScreen() {
        preferences.saveDestinationScreen(destinationScreen = Screen.MainScreen.route)
    }

    private fun getPlayers() {
        getPlayersJob?.cancel()
        getPlayersJob = allUseCases.getPlayers()
            .onEach { items ->
                _players.value = items
            }
            .launchIn(viewModelScope)
    }

    private fun loadColorJersey() {
        _jerseyColors.value.colorJersey = Colors.indexToColor(preferences.loadColorJersey())
    }

    private fun loadColorStripes() {
        _jerseyColors.value.colorStripes = Colors.indexToColor(preferences.loadColorStripes())
    }

    private fun loadTactics() {
        _tactics.value = allUseCases.getTactics(preferences.loadTactics().toString())
    }

    private fun loadAllTactics() {
        _allTactics.value = ALL_TACTICS
    }

    fun saveTactics(tactics: List<Any>) {
        _tactics.value = tactics
        preferences.saveTactics(tactics[0].toString())
    }

    fun getPlayer(players: List<Player>, tactics: List<Any>, item1: Int, item2: Int): Player? {
        return allUseCases.getPlayer(players, tactics, item1, item2)
    }

    fun getPlayerInfo(player: Player?): String {
        return allUseCases.getPlayerInfo(player)
    }

    fun replaceTwoPlayers(
        previouslyClickedInfo: MarkedPlayer,
        item1: Int,
        item2: Int,
        color: Color
    ) {
        viewModelScope.launch {
            _previouslyClickedInfo.value =
                allUseCases.replaceTwoPlayers(previouslyClickedInfo, item1, item2, color)
            getPlayers()
        }
    }

    fun checkPlayerInRightPosition(
        player: Player?, item1: Int, item2: Int, tactics: List<Any>
    ): Boolean {
        return allUseCases.checkPlayerInRightPosition(player, item1, item2, tactics)
    }

    fun calculatingFirstTeamRating(players: List<Player>, tactics: List<Any>): Double {
        val rating = allUseCases.CalculationFirstTeamRating(players, tactics)
        saveFirstTeamRating(rating)
        return rating
    }

    private fun saveFirstTeamRating(rating: Double) {
        viewModelScope.launch {
            allUseCases.saveFirstTeamRating(preferences.loadClubName(), rating)
        }
    }

    fun increaseRound() {
        val round = preferences.loadRoundNumber()
        playRound(round + 1)
        if (round < 38) {
            preferences.saveRoundNumber(round + 1)
        }
    }

    private fun playRound(round: Int) {
        viewModelScope.launch {
            allUseCases.playRound(round)
        }
    }
}