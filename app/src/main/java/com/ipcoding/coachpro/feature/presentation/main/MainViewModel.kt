package com.ipcoding.coachpro.feature.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.util.Constants.CHANGE_HISTORY
import com.ipcoding.coachpro.core.util.Constants.CHANGE_PLAYERS_YEAR
import com.ipcoding.coachpro.core.util.Constants.PREPARING_FOR_NEW_SEASON
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import com.ipcoding.coachpro.feature.domain.util.WeekType
import com.ipcoding.coachpro.ui.theme.Colors.indexToColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
): ViewModel() {

    private var _league = mutableStateOf("")

    private var _clubName = mutableStateOf("")
    val clubName: State<String> = _clubName

    private var _colorJersey = mutableStateOf(Color.Red)
    val colorJersey: State<Color> = _colorJersey

    private var _colorStripes = mutableStateOf(Color.White)

    private var _colorText = mutableStateOf(Color.White)
    val colorText: State<Color> = _colorText

    private var _clubPosition = mutableStateOf("")
    val clubPosition: State<String> = _clubPosition

    private var _clubRating = mutableStateOf(0.0)
    val clubRating: State<Double> = _clubRating

    private var _playersRating = mutableStateOf(0.0)
    val playersRating: State<Double> = _playersRating

    private var _roundNumber = mutableStateOf(0)
    val roundNumber: State<Int> = _roundNumber

    private var _year = mutableStateOf(0)
    val year: State<Int> = _year

    private var _week = mutableStateOf(0)
    val week: State<Int> = _week

    private var _month = mutableStateOf("")
    val month: State<String> = _month

    private var _info = mutableStateOf<WeekType?>(null)
    val info: State<WeekType?> = _info

    init {
        loadClubName()
        loadSelectedLeague()
        loadRoundNumber()
        loadYear()
        loadWeek()
        getMonth()
        getInfoText()
        loadColorJersey()
        loadColorStripes()
        getPlayersRating()
        getClubRating()
        checkColors()
        getClubPositionString()
    }

    private fun checkColors() {
        _colorText.value = allUseCases.checkColors(_colorJersey.value, _colorStripes.value)
    }

    private fun getInfoText() {
        viewModelScope.launch {
            _info.value =
                allUseCases.getWeekTypeText.invoke(_week.value + 1, false)
        }
    }

    private fun loadClubName() {
        _clubName.value = preferences.loadClubName().toString()
    }

    private fun loadRoundNumber() {
        _roundNumber.value = preferences.loadRoundNumber()
    }

    private fun loadYear() {
        _year.value = preferences.loadYear()
    }

    private fun loadWeek() {
        _week.value = preferences.loadWeek()
    }

    fun saveWeekYear()  {
        when(_week.value) {
            PREPARING_FOR_NEW_SEASON -> preparingForNewSeason()
            CHANGE_HISTORY -> changeHistory()
            CHANGE_PLAYERS_YEAR -> changePlayersYear()
            52 -> {
                preferences.saveYear(_year.value + 1)
                _week.value = 0
            }
        }
        preferences.saveWeek(_week.value + 1)
        loadWeek()
        loadYear()
        getMonth()
    }

    private fun changePlayersYear() {
        viewModelScope.launch {
            allUseCases.changePlayersYear.invoke()
        }
    }

    private fun changeHistory() {
        viewModelScope.launch {
            allUseCases.changeHistory.invoke(_league.value, _year.value, _clubName.value)
        }
    }

    private fun preparingForNewSeason() {
        viewModelScope.launch {
            allUseCases.preparingForNewSeason.invoke(_clubName.value, _league.value.toInt())
        }
    }

    private fun loadColorJersey() {
        _colorJersey.value = indexToColor(preferences.loadColorJersey())
    }

    private fun loadColorStripes() {
        _colorStripes.value = indexToColor(preferences.loadColorStripes())
    }

    private fun loadSelectedLeague() {
        _league.value = preferences.loadSelectedLeague().toString()
    }

    fun getStringLeague(): String {
       return allUseCases.getStringLeague(_league.value)
    }

    fun getClubPositionString() {
        viewModelScope.launch {
            _clubPosition.value =
                allUseCases.getClubPositionString.invoke(_clubName.value)
        }
    }

    private fun getPlayersRating() {
        viewModelScope.launch {
            allUseCases.getPlayersRating.invoke(_clubName.value)?.let {
                _playersRating.value = it
            }
        }
    }

    private fun getClubRating() {
        viewModelScope.launch {
            allUseCases.getClubRating.invoke(_clubName.value)?.let {
                _clubRating.value = it
            }
        }
    }

    private fun getMonth() {
        _month.value = allUseCases.getMonth.invoke(_week.value, _year.value)
    }
}