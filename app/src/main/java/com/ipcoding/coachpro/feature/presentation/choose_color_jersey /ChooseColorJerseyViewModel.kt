package com.ipcoding.coachpro.feature.presentation.choose_color_jersey

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.util.Constants.START_SEASON_WEEK
import com.ipcoding.coachpro.core.util.Constants.START_SEASON_YEAR
import com.ipcoding.coachpro.ui.theme.Colors
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChooseColorJerseyViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    private var _colorJersey = mutableStateOf(Color.Red)
    val colorJersey: State<Color> = _colorJersey

    private var _colorStripes = mutableStateOf(Color.White)
    val colorStripes: State<Color> = _colorStripes

    init {
        saveColorJersey(_colorJersey.value)
        saveColorStripes(_colorStripes.value)
        saveYear()
        saveWeek()
    }

    fun saveColorJersey(color: Color)  {
        _colorJersey.value = color
        preferences.saveColorJersey(Colors.colorToIndex(color))
    }

    fun saveColorStripes(color: Color)  {
        _colorStripes.value = color
        preferences.saveColorStripes(Colors.colorToIndex(color))
    }

    fun saveYear()  {
        preferences.saveYear(START_SEASON_YEAR)
    }

    fun saveWeek()  {
        preferences.saveWeek(START_SEASON_WEEK)
    }
}