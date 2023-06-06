package com.example.car_integrity_monitor_movile_app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.car_integrity_monitor_movile_app.bottomnav.BottomNavItem
import com.example.car_integrity_monitor_movile_app.ui.screens.*

/**
 * Function that creates the app bar
 * @param modifier
 * @return Unit
 */
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

/**
 * Function that creates the bottom navigation bar
 * @param modifier
 * @param navController
 * @return Unit
 */
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

/**
 * CimApp is the main entry point of the app.
 * It is responsible for setting up the navigation graph
 * @param modifier
 * @param navController
 * @see CimAppBar
 * @see CimBottomNavigationBar
 * @see CarStateScreen
 * @see CarAnomalyScreen
 * @see CarNotificationScreen
 * @see CarStateViewModel
 * @see CarAnomalyViewModel
 * @see CarNotificationViewModel
 * @return Unit
 */
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
        val carStateViewModel: CarStateViewModel =
            viewModel(factory = CarStateViewModel.Factory)
        val carAnomalyViewModel: CarAnomalyViewModel =
            viewModel(factory = CarAnomalyViewModel.Factory)
        val carNotificationViewModel: CarNotificationViewModel =
            viewModel(factory = CarNotificationViewModel.Factory)
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

                CarAnomalyScreen(
                    carAnomalyState = carAnomalyViewModel.carAnomalyState,
                    retryAction = carAnomalyViewModel::getCarAnomalies,
                )
            }
            composable(BottomNavItem.Notification.screen_route.toString()){

                CarNotificationScreen(
                    isNotificationActive = carNotificationViewModel.isNotificationActive,
                    changeNotificationActiveState = carNotificationViewModel::changeNotificationActiveState
                )
            }
        }
    }
}



