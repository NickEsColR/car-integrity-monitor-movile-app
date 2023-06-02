package com.example.car_integrity_monitor_movile_app.model


data class CarState (
    val rpm: String,
    val mph: String,
    val throttle: String,
    val engine_temperature: String,
    val airflow: String
)