package com.example.car_integrity_monitor_movile_app.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class CimStateScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun clickGetStateButtonOnStateScreen_receiveResponse(){
        //TODO: Check if the response is received
    }

    @Test
    fun clickGetStateButtonOnStateScreen_NotReceiveResponse(){
        //Todo: Check if the response is not received
    }
}