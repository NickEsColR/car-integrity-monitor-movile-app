package com.example.car_integrity_monitor_movile_app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
//import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.car_integrity_monitor_movile_app.bottomnav.BottomNavItem
import com.example.car_integrity_monitor_movile_app.ui.screens.*


@Composable
fun CimAppBar(
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "menu bar"
                )
            }
        }
    )
}

@Composable
fun CimBottomNavigationBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        BottomNavItem.CarState,
        BottomNavItem.CarAnomaly,
        BottomNavItem.Notification
    )

    BottomNavigation(modifier = modifier) {
        items.forEachIndexed{index, item ->
            BottomNavigationItem(
                icon = { Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = stringResource(id = item.title)
                )},
                label = { Text(text = stringResource(id = item.title)) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.screen_route.toString())
                }
            )
        }
    }
}

@Composable
fun CimApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
){

    // Get current back stack entry
    //val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    /*val currentScreen = CimScreen.valueOf(
        backStackEntry?.destination?.route ?: CimScreen.CarState.name
    )*/

    Scaffold(
        topBar = { CimAppBar() },
        bottomBar = { CimBottomNavigationBar(navController = navController) }
    ) {
        val carStateViewModel: CarStateViewModel = CarStateViewModel()
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.CarState.screen_route.toString(),
            modifier = modifier.padding(it)
        ){
            composable(BottomNavItem.CarState.screen_route.toString()){
                CarStateScreen(
                    carStateUiState = carStateViewModel.carStateUiState,
                    retryAction = carStateViewModel::getCarStatus
                )
            }
            composable(BottomNavItem.CarAnomaly.screen_route.toString()){
                CarAnomalyScreen()
            }
            composable(BottomNavItem.Notification.screen_route.toString()){
                CarNotificationScreen()
            }
        }
    }
}



