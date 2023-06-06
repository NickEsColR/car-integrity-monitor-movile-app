package com.example.car_integrity_monitor_movile_app.ui.screens

import com.example.car_integrity_monitor_movile_app.model.CarState

sealed interface CarStateUiState {
    data class Success(val carState: CarState): CarStateUiState
    object Error: CarStateUiState
    object Loading: CarStateUiState
    object Entry: CarStateUiState
}