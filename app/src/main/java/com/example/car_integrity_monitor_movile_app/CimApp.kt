package com.example.car_integrity_monitor_movile_app

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.car_integrity_monitor_movile_app.bottomnav.BottomNavItem
import com.example.car_integrity_monitor_movile_app.ui.screens.CarStateScreen



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
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "menu bar"
                )
            }
        }
    )
}

@Composable
fun CimBottomNavigationBar(
    modifier: Modifier = Modifier
){
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf(
        BottomNavItem.CarState,
        BottomNavItem.CarAnomaly,
        BottomNavItem.Notification
    )

    BottomNavigation {
        items.forEachIndexed{index, item ->
            BottomNavigationItem(
                icon = { Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = stringResource(id = item.title)
                )},
                label = { Text(text = stringResource(id = item.title)) },
                selected = selectedItem == index,
                onClick = { /*TODO*/ }
            )
        }
    }
}

@Composable
fun CimApp(
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = { CimAppBar() },
        bottomBar = { CimBottomNavigationBar() }
    ) {
        CarStateScreen()
    }
}



