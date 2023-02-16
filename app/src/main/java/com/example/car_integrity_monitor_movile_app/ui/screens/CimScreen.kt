package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.annotation.StringRes
import com.example.car_integrity_monitor_movile_app.R

enum class CimScreen(@StringRes val route: Int) {
    CarState(route = R.string.car_state_route),
    CarAnomaly(route = R.string.car_anomaly_route),
    Notification(route = R.string.car_notification_route)
}