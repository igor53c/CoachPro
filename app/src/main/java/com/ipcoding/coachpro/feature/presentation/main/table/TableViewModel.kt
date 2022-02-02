package com.ipcoding.coachpro.feature.presentation.main.table

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

    fun getColor(club: Club): Color {
        return allUseCases.getColorOfClubInTable.invoke(
            club = club,
            selecktedClub = preferences.loadClubName().toString()
        )
    }

    private fun getClubs() {
        viewModelScope.launch {
            _clubs.value = allUseCases.getClubs.invoke(getStringLeague())
        }
    }

    fun getStringLeague(): String {
        return allUseCases.getStringLeague(preferences.loadSelecktedLeague().toString())
    }
}