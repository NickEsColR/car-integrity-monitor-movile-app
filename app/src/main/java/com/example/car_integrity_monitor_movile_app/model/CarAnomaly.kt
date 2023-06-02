package com.example.car_integrity_monitor_movile_app.model

import java.io.Serializable

data class CarAnomaly(
    val code: String = "",
    val letter: String = "",
    val number: String = "",
    val subsystem_number: String = ""
): Serializable
