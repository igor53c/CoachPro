package com.ipcoding.coachpro.feature.presentation.result

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.model.Match
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
) : ViewModel() {

    private var _roundNumber = mutableStateOf(0)
    val roundNumber: State<Int> = _roundNumber

    private var _match = mutableStateOf<Match?>(null)
    val match: State<Match?> = _match

    private var _clubName = mutableStateOf("")
    val clubName: State<String> = _clubName

    private var matchJob: Job? = null

    init {
        loadClubName()
        loadRoundNumber()
        getClubMatchFromNextRound()
    }

    private fun getClubMatchFromNextRound() {
        matchJob?.cancel()
        matchJob = allUseCases.getClubMatchFromNextRound(_roundNumber.value, _clubName.value)
            .onEach { match ->
                _match.value = match
            }
            .launchIn(viewModelScope)
    }

    private fun loadRoundNumber() {
        _roundNumber.value = preferences.loadRoundNumber()
    }

    private fun loadClubName() {
        _clubName.value = preferences.loadClubName().toString()
    }
}