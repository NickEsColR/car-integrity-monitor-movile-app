package com.example.car_integrity_monitor_movile_app.test

import androidx.navigation.NavController
import org.junit.Assert.assertEquals

fun NavController.assertCurrentRouteName(expectedRouteName: String){
    assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}