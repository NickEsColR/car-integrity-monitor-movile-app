package com.example.car_integrity_monitor_movile_app.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class CarNotificationScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()


    @Test
    fun cimNavHost_clickActivateNotificationButtonOnNotificationScreen_changeText() {
        //TODO: Check if button works
    }

    @Test
    fun cimNavHost_clickDeactivateNotificationButtonOnNotificationScreen_changeText(){
        //TODO: Check if button works
    }
}