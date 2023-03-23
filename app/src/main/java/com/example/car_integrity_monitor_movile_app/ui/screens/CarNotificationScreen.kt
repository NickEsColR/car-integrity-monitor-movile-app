package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.car_integrity_monitor_movile_app.R

@Composable
fun CarNotificationScreen(
    modifier: Modifier = Modifier,
    isNotificationActive: Boolean,
    changeNotificationActiveState: () -> Unit,
    requestNotification: () -> Unit
){
    Column(modifier = modifier) {
        Button(onClick =  changeNotificationActiveState ) {
            Text(text = if (isNotificationActive) "Desactivar notificación" else "Activar notificación" )
        }
        Button(onClick = requestNotification ) {
            Text(text = "Solicitar notificación")
        }
        Text("Sobre las notificaciones")
        Text("info...")
    }
}

