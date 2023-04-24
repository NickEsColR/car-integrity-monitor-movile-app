package com.example.car_integrity_monitor_movile_app.data

import com.example.car_integrity_monitor_movile_app.model.CarState

interface CarStateRepository {
    suspend fun getCarStates(): List<CarState>
}