package com.example.car_integrity_monitor_movile_app.data

import com.example.car_integrity_monitor_movile_app.model.CarAnomaly

interface CarAnomalyRepository {
    suspend fun getCarAnomalies(): List<CarAnomaly>
}