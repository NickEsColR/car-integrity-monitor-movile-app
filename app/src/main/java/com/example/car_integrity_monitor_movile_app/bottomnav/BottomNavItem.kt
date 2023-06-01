package com.example.car_integrity_monitor_movile_app.bottomnav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.car_integrity_monitor_movile_app.R
import com.example.car_integrity_monitor_movile_app.ui.screens.CimScreen

sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @StringRes val screen_route: Int,
){
    object CarState: BottomNavItem(
        R.string.car_state,
        R.drawable.ic_car_state,
        CimScreen.CarState.route
    )
    object CarAnomaly: BottomNavItem(
        R.string.car_anomaly,
        R.drawable.ic_car_anomaly,
        CimScreen.CarAnomaly.route
    )
    object Notification: BottomNavItem(
        R.string.notification,
        R.drawable.ic_notification,
        CimScreen.Notification.route
    )
}
