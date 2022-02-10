package com.ipcoding.coachpro.feature.presentation.table

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TableViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
): ViewModel() {

    private var _clubs = mutableStateOf<List<Club>>(emptyList())
    val clubs: State<List<Club>> = _clubs

    init {
        getClubs()
    }

    fun getColorOfClubInTable(position: Int): Color {
        return allUseCases.getColorOfClubInTable.invoke(position)
    }

    fun getClubName(): String {
        return preferences.loadClubName().toString()
    }

    private fun getClubs() {
        viewModelScope.launch {
            if(preferences.loadRoundNumber() != 0)
                _clubs.value = allUseCases.getClubs.invoke(getStringLeague()) else
                _clubs.value = allUseCases.getClubsFromLeagueByPosition.invoke(getStringLeague())
        }
    }

    fun getStringLeague(): String {
        return allUseCases.getStringLeague(preferences.loadSelectedLeague().toString())
    }
}