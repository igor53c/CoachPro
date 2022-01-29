package com.ipcoding.coachpro.feature.presentation.start

import androidx.lifecycle.ViewModel
import com.ipcoding.coachpro.core.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {

    init {
        preferences.saveClubName("Red Star")
    }

    fun loadClubName() : String {
      return preferences.loadClubName() ?: ""
    }
}