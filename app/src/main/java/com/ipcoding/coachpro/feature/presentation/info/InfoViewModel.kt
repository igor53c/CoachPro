package com.ipcoding.coachpro.feature.presentation.info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import com.ipcoding.coachpro.feature.domain.util.WeekType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
): ViewModel() {

    private var _week = mutableStateOf(0)
    val week: State<Int> = _week

    private var _info = mutableStateOf<WeekType?>(null)
    val info: State<WeekType?> = _info

    init {
        loadWeek()
        getInfoText()
    }

    private fun getInfoText() {
        _info.value = allUseCases.getWeekTypeText.invoke(_week.value)
    }

    private fun loadWeek() {
        _week.value = preferences.loadWeek()
    }
}