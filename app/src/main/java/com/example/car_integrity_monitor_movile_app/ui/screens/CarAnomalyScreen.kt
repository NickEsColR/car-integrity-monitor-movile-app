package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.car_integrity_monitor_movile_app.R

@Composable
fun CarAnomalyScreen(
    modifier: Modifier = Modifier,
    carAnomalyState: CarAnomalyState,
    retryAction: () -> Unit
){
    when(carAnomalyState){
        is CarAnomalyState.Loading -> LoadingScreen()
        is CarAnomalyState.Success -> SuccessScreen()
        is CarAnomalyState.Error -> ErrorScreen(retryAction = retryAction)
    }
}

/**
 * The car Anomaly screen displaying the loading message
 */
@Composable
private fun LoadingScreen(modifier: Modifier = Modifier){
    Column(modifier = modifier
    ){
        Text(text = "Lista de las Anomalias registradas")
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.loading_img),
                contentDescription = "Cargando",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}

/**
 * The car Anomaly screen displaying the error message
 */
@Composable
private fun ErrorScreen(modifier: Modifier = Modifier, retryAction: () -> Unit){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
            .padding(16.dp)
    ){
        Column {
            Text(text = "Error al cargar la lista de anomalias")
            Button(onClick = retryAction) {
                Text(text = "Reintentar")
            }
        }
    }

}

/**
 * The car Anomaly screen displaying the success message
 */
@Composable
private fun SuccessScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxSize()
    ){
        Text(text = "Lista de las Anomalias registradas")
        Text(text = "info...")
    }
}