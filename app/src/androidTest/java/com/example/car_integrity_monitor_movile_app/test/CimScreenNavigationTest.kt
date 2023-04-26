package com.example.car_integrity_monitor_movile_app.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.car_integrity_monitor_movile_app.CimApp
import com.example.car_integrity_monitor_movile_app.ui.screens.CimScreen
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CimScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupCimNavHost(){
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(
                ComposeNavigator()
            )
            CimApp(navController = navController)
        }
    }

    @Test
    fun cimNavHost_verifyStartDestination(){
        navController.assertCurrentRouteName(CimScreen.CarState.name)
    }

    @Test
    fun cimNavHost_navigateToCarAnomaly(){
        navController.navigate(CimScreen.CarAnomaly.name)
        navController.assertCurrentRouteName(CimScreen.CarAnomaly.name)
    }

    @Test
    fun cimNavHost_navigateToNotification(){
        navController.navigate(CimScreen.Notification.name)
        navController.assertCurrentRouteName(CimScreen.Notification.name)
    }

    @Test
    fun cimNavHost_navigateToCarState(){
        navController.navigate(CimScreen.CarState.name)
        navController.assertCurrentRouteName(CimScreen.CarState.name)
    }





}