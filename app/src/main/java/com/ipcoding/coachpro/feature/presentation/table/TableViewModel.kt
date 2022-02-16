package com.ipcoding.coachpro.feature.presentation.table

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.util.Constants.PREPARATION_OF_CLUBS_AND_SCHEDULING
import com.ipcoding.coachpro.core.util.Constants.START_MATCHES_ONE
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
        return allUseCases.getColorOfClubInTable(position)
    }

    fun getClubName(): String {
        return preferences.loadClubName().toString()
    }

    private fun getClubs() {
        viewModelScope.launch {
            val league = getStringLeague()
            _clubs.value = when(preferences.loadWeek()) {
                in PREPARATION_OF_CLUBS_AND_SCHEDULING..START_MATCHES_ONE ->
                    allUseCases.getClubsFromLeagueByPosition(league)
                else -> allUseCases.getClubs(league)
            }
        }
    }

    fun getStringLeague(): String {
        return allUseCases.getStringLeague(preferences.loadSelectedLeague().toString())
    }
}