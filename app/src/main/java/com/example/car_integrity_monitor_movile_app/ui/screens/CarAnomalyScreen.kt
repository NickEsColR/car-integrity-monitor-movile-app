package com.example.car_integrity_monitor_movile_app.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car_integrity_monitor_movile_app.R
import com.example.car_integrity_monitor_movile_app.model.CarAnomaly

/**
 * The car Anomaly screen displaying the success message
 * @param carAnomalyState
 * @param modifier
 * @param retryAction
 * @return Unit
 */
@Composable
fun CarAnomalyScreen(
    modifier: Modifier = Modifier,
    carAnomalyState: CarAnomalyState,
    retryAction: () -> Unit
){
    when(carAnomalyState){
        is CarAnomalyState.Loading -> {
            Column(modifier = modifier) {
                Text(
                    text = stringResource(R.string.anomaly_title),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                LoadingScreen()
            }
        }
        is CarAnomalyState.Success -> {
            Column(modifier =  modifier) {
                Text(
                    text = stringResource(R.string.anomaly_title),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                SuccessScreen(carAnomalies = carAnomalyState.carAnomalies)
            }
        }
        is CarAnomalyState.Error -> {
            Column(modifier = modifier) {
                Text(
                    text = stringResource(R.string.anomaly_title),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
                ErrorScreen(retryAction = retryAction)
            }
        }
    }
}

/**
 * The car Anomaly screen displaying the loading message
 * @param modifier
 * @return Unit
 */
@Composable
private fun LoadingScreen(modifier: Modifier = Modifier){

        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.loading_img),
                contentDescription = stringResource(R.string.loading_text),
                modifier = Modifier.size(200.dp)
            )
        }
}

/**
 * The car Anomaly screen displaying the error message
 * @param modifier
 * @param retryAction
 * @return Unit
 */
@Composable
private fun ErrorScreen(modifier: Modifier = Modifier, retryAction: () -> Unit){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Column {
            Text(
                text = stringResource(R.string.anomaly_error),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = androidx.compose.ui.graphics.Color.Red
            )
            Button(onClick = retryAction) {
                Text(text = stringResource(R.string.retry_string))
            }
        }
    }

}

/**
 * The car Anomaly screen displaying the success message
 * @param modifier
 * @param carAnomalies
 * @return Unit
 */
@Composable
private fun SuccessScreen(modifier: Modifier = Modifier, carAnomalies: List<CarAnomaly>){
    Log.i("CarAnomalyScreen",carAnomalies.toString())
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ){
        items(carAnomalies){ carAnomaly ->
            CarAnomalyItem(carAnomaly = carAnomaly)
        }
    }
}

/**
 * Composable function to create a car anomaly item in a single row
 * @param carAnomaly the car Anomaly
 * @param modifier Modifier
 *@return [Unit]
 */
@Composable
private fun CarAnomalyItem(
    modifier: Modifier = Modifier,
    carAnomaly: CarAnomaly
){
    androidx.compose.material.Card(modifier = Modifier.padding(8.dp), elevation = 8.dp) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Text(text = getAnomalyText(carAnomaly.letter))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "codigo: ${carAnomaly.code}")
            Spacer(modifier = Modifier.width(16.dp))
            if (carAnomaly.letter == "P"){
                Text(text = "subsistema: "+getSubsystemText(carAnomaly.subsystem_number))
            }
        }
    }
}

/**
 * function that returns a text depending on the car anomaly letter
 * @param letter the letter of the car anomaly
 * @return [String]
 */
private fun getAnomalyText(letter: String): String {
    return when (letter) {
        "P" -> "Problemas en el motor"
        "B" -> "Problema en partes internas"
        "C" -> "Problema de chasis"
        "U" -> "Problema en integración de subsistemas"
        else -> "Anomalia desconocida"
    }
}

/**
 * Function that returns a text depending on the car anomaly subsystem
 * @param subsystem the subsystem of the car anomaly
 * @return [String]
 */
private fun getSubsystemText(subsystem: String): String {
    return when (subsystem) {
        "0" -> "controles auxiliares de emisiones"
        "1" -> "Medición de combustible y aire"
        "2" -> "circuito de inyectores"
        "3" -> "Sistemas de encendido"
        "4" -> "Controles auxiliares de emisiones"
        "5" -> "Control de la velocidad del vehículo"
        "6" -> "Ordenador y circuito de salida"
        "7" -> "Transmisión"
        else -> "Subsistema desconocido"
    }
}