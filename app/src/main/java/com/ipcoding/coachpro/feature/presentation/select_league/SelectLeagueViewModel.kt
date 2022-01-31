package com.ipcoding.coachpro.feature.presentation.select_league

import androidx.lifecycle.ViewModel
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelectLeagueViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    fun saveSelecktedLeague(name: String)  {
        preferences.saveSelecktedLeague(name)
    }
}