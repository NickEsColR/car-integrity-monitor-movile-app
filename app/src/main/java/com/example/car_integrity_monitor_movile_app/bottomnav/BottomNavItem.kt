package com.example.car_integrity_monitor_movile_app.bottomnav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.example.car_integrity_monitor_movile_app.R

sealed class BottomNavItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @StringRes val screen_route: Int,
){
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
