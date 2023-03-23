package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class CarNotificationViewModel: ViewModel() {
    var isNotificationActive by mutableStateOf(true)
        private set

    /**
     * Factory for CarNotificationViewModel
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CarNotificationViewModel()
            }
        }
    }

    /**
     * Change the notification active state
     */
    fun changeNotificationActiveState() {
        isNotificationActive = !isNotificationActive
    }

    /**
     * request for a notification to the server
     * TODO: implement
     */
    fun requestNotification() {
        return //TODO
    }
}