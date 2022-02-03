package com.ipcoding.coachpro.feature.presentation.tactics

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.util.Colors
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TacticsViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
): ViewModel() {

    private var _colorJersey = mutableStateOf(Color.Red)
    val colorJersey: State<Color> = _colorJersey

    private var _colorStripes = mutableStateOf(Color.White)
    val colorStripes: State<Color> = _colorStripes

    init {
        loadColorJersey()
        loadColorStripes()
        _colorStripes.value =
            allUseCases.checkColors(_colorJersey.value, _colorStripes.value)
    }

    fun loadColorJersey() {
        _colorJersey.value = Colors().indexToColor(preferences.loadColorJersey())
    }

    fun loadColorStripes() {
        _colorStripes.value = Colors().indexToColor(preferences.loadColorStripes())
    }

}