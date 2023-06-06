package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.car_integrity_monitor_movile_app.httpServices.changeSendAlarm

class CarNotificationViewModel: ViewModel() {
    var isNotificationActive by mutableStateOf(true)
        private set

    /**
     * Factory for CarNotificationViewModel
     * @return ViewModelProvider.Factory
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
     * @return Unit
     */
    fun changeNotificationActiveState() {
        isNotificationActive = !isNotificationActive
        changeSendAlarm()
    }

}