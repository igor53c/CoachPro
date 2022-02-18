package com.ipcoding.coachpro.feature.presentation.schedule

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.model.Match
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
) : ViewModel() {

    private var _clubName = mutableStateOf("")
    val clubName: State<String> = _clubName

    private var _round = mutableStateOf(-1)
    val round: State<Int> = _round

    private val _matches = mutableStateOf<List<Match>>(emptyList())
    val matches: State<List<Match>> = _matches

    init {
        getAllMatches()
        loadClubName()
        loadRoundNumber()
    }

    private fun loadRoundNumber() {
        _round.value = preferences.loadRoundNumber()
    }

    private fun loadClubName() {
        _clubName.value = preferences.loadClubName().toString()
    }

    fun getStringLeague(): String {
        return allUseCases.getStringLeague(preferences.loadSelectedLeague().toString())
    }

    private fun getAllMatches() {
        allUseCases.getAllMatches()
            .onEach { items ->
                _matches.value = items
            }
            .launchIn(viewModelScope)
    }
}