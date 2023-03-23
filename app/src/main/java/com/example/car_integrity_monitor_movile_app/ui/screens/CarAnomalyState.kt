package com.example.car_integrity_monitor_movile_app.ui.screens

sealed interface CarAnomalyState{
    object Success: CarAnomalyState
    object Error: CarAnomalyState
    object Loading: CarAnomalyState
}