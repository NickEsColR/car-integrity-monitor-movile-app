package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CarNotificationScreen(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Activar/Desactivar notificaciones")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Solicitar notificación")
        }
        Text("Sobre las notificaciones")
        Text("info...")
    }
}