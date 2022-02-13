package com.ipcoding.coachpro.feature.presentation.history

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.coachpro.feature.domain.model.History
import com.ipcoding.coachpro.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val allUseCases: AllUseCases
): ViewModel() {

    private val _history = mutableStateOf<List<History>>(emptyList())
    val history: State<List<History>> = _history

    init {
        getHistory()
    }

    private fun getHistory() {
        viewModelScope.launch {
            _history.value = allUseCases.getHistory()
         }
    }
}