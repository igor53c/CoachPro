package com.ipcoding.coachpro.feature.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.core.util.Colors
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferences: Preferences,
    allUseCases: AllUseCases
): ViewModel() {

    private var _clubName = mutableStateOf("")
    val clubName: State<String> = _clubName

    private var _colorJersey = mutableStateOf(Color.Red)
    val colorJersey: State<Color> = _colorJersey

    private var _colorStripes = mutableStateOf(Color.White)
    val colorStripes: State<Color> = _colorStripes

    init {
        loadClubName()
        loadColorJersey()
        loadColorStripes()
        _colorStripes.value =
            allUseCases.checkColors(_colorJersey.value, _colorStripes.value)
    }

    fun loadClubName() {
        _clubName.value = preferences.loadClubName().toString()
    }

    fun loadColorJersey() {
        _colorJersey.value = Colors().indexToColor(preferences.loadColorJersey())
    }

    fun loadColorStripes() {
        _colorStripes.value = Colors().indexToColor(preferences.loadColorStripes())
    }
}