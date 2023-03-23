package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CarAnomalyViewModel: ViewModel(){
    var carAnomalyState: CarAnomalyState by mutableStateOf(CarAnomalyState.Loading)
        private set

    /**
     * Initialize the car anomaly state to load information
     */
    init {
        getCarAnomalies()
    }

    /**
     * Get the car anomalies and update state
     * currentrly version just change status without information
     */
    fun getCarAnomalies() {
        viewModelScope.launch {
            delay(10000L)
            carAnomalyState = CarAnomalyState.Success
        }
    }

    /**
     * Factory for CarAnomalyViewModel
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CarAnomalyViewModel()
            }
        }
    }
}