package com.ipcoding.coachpro.feature.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.model.Club
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import com.ipcoding.coachpro.ui.theme.Colors.indexToColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
): ViewModel() {

    private var _clubName = mutableStateOf("")
    val clubName: State<String> = _clubName

    private var _colorJersey = mutableStateOf(Color.Red)
    val colorJersey: State<Color> = _colorJersey

    private var _colorStripes = mutableStateOf(Color.White)
    val colorStripes: State<Color> = _colorStripes

    private var _club = mutableStateOf<Club?>(null)
    val club: State<Club?> = _club

    private var _clubPosition = mutableStateOf("")
    val clubPosition: State<String> = _clubPosition

    private var _clubRating = mutableStateOf(0.0)
    val clubRating: State<Double> = _clubRating

    private var _playersRating = mutableStateOf(0.0)
    val playersRating: State<Double> = _playersRating

    init {
        loadClubName()
        loadColorJersey()
        loadColorStripes()
        getPlayersRating()
        getClubRating()
        _colorStripes.value =
            allUseCases.checkColors(_colorJersey.value, _colorStripes.value)
        getClubPositionString()
    }

    private fun loadClubName() {
        _clubName.value = preferences.loadClubName().toString()
    }

    private fun loadColorJersey() {
        _colorJersey.value = indexToColor(preferences.loadColorJersey())
    }

    private fun loadColorStripes() {
        _colorStripes.value = indexToColor(preferences.loadColorStripes())
    }

    fun getStringLeague(): String {
       return allUseCases.getStringLeague(preferences.loadSelectedLeague().toString())
    }

    fun getClubPositionString() {
        viewModelScope.launch {
            _clubPosition.value =
                allUseCases.getClubPositionString.invoke(_clubName.value)
        }
    }

    fun getPlayersRating() {
        viewModelScope.launch {
            allUseCases.getPlayersRating.invoke(_clubName.value)?.let {
                _playersRating.value = it
            }
        }
    }

    fun getClubRating() {
        viewModelScope.launch {
            allUseCases.getClubRating.invoke(_clubName.value)?.let {
                _clubRating.value = it
            }
        }
    }
}