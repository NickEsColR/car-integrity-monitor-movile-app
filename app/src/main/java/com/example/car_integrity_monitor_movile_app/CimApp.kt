package com.example.car_integrity_monitor_movile_app

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.car_integrity_monitor_movile_app.ui.screens.StateScreen



@Composable
fun CimAppBar(
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text("Titulo") },
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
fun CimApp(
    modifier: Modifier = Modifier
){
    Scaffold(topBar = { CimAppBar()}) {
        StateScreen()

    }
}



