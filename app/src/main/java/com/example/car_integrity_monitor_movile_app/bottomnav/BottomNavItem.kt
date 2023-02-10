package com.example.car_integrity_monitor_movile_app.bottomnav

import androidx.compose.ui.res.stringResource
import com.example.car_integrity_monitor_movile_app.R

sealed class BottomNavItem(var title:Int, var icon:Int, var screen_route:Int){
    object CarState: BottomNavItem(
        R.string.car_state,
        R.drawable.ic_car_state,
        R.string.car_state_route
    )
    object CarAnomaly: BottomNavItem(
        R.string.car_anomaly,
        R.drawable.ic_car_anomaly,
        R.string.car_anomaly_route
    )
    object Notification: BottomNavItem(
        R.string.notification,
        R.drawable.ic_notification,
        R.string.car_notification_route
    )
}
