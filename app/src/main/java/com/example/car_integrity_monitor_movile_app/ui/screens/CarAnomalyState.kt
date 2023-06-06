package com.example.car_integrity_monitor_movile_app.ui.screens

import com.example.car_integrity_monitor_movile_app.model.CarAnomaly

sealed interface CarAnomalyState{
    data class Success(val carAnomalies: List<CarAnomaly>): CarAnomalyState
    object Error: CarAnomalyState
    object Loading: CarAnomalyState
}