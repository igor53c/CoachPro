package com.ipcoding.coachpro.feature.presentation.select_club

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectClubViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
) : ViewModel() {

    private var _clubs = mutableStateOf<Array<String>>(emptyArray())
    val clubs: State<Array<String>> = _clubs

    init {
        _clubs.value = allUseCases
            .getClubsFromLeague(
                preferences.loadSelectedLeague()
            )
    }

    fun saveClubName(name: String) {
        preferences.saveClubName(name)
    }

    private fun saveRoundNumber() {
        preferences.saveRoundNumber(0)
    }

    fun createClubDatabase() {
        viewModelScope.launch {
            preferences.loadClubName()?.let { allUseCases.createClubDatabase(it) }
        }

        saveRoundNumber()
    }
}