package com.ipcoding.coachpro.feature.presentation.select_club

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SelectClubViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    private val _league = mutableStateOf("")
    val league: State<String> = _league

    init {
        _league.value = preferences.loadSelecktedLeague().toString()
    }
}