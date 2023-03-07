package com.example.car_integrity_monitor_movile_app.ui.screens

sealed interface CarStateUiState {
    object Success: CarStateUiState
    object Error: CarStateUiState
    object Loading: CarStateUiState
    object Entry: CarStateUiState
}