package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.car_integrity_monitor_movile_app.R

@Composable
fun CarStateScreen(
    modifier: Modifier = Modifier,
    carStateUiState: CarStateUiState,
    retryAction: () -> Unit
){
    when (carStateUiState){
        is CarStateUiState.Entry -> EntryScreen(retryAction = retryAction)
        is CarStateUiState.Loading -> LoadingScreen()
        is CarStateUiState.Success -> SuccessScreen(retryAction = retryAction)
        is CarStateUiState.Error -> ErrorScreen(retryAction = retryAction)
    }
}

/**
 * The car state screen displaying the entry message
 */
@Composable
private fun EntryScreen(modifier: Modifier = Modifier, retryAction: () -> Unit){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Column{
            Text(text = "Recuerda iniciar el vehículo para poder ver el estado")
            Button(onClick = retryAction) {
                Text(text = stringResource(R.string.car_state_button))
            }
        }
    }
}

/**
 * The car state screen displaying the loading message
 */
@Composable
private fun LoadingScreen(modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.loading_img),
            contentDescription = "Cargando",
            modifier = Modifier.size(200.dp)
        )
    }
}

/**
 * The car state screen displaying the state information
 */
@Composable
private fun SuccessScreen(modifier: Modifier = Modifier, retryAction: () -> Unit){
    Column(modifier) {
        Text(text = "En esta pantalla se vera la información del estado")
        Button(onClick = retryAction) {
            Text(text = stringResource(R.string.car_state_button))
        }
    }
}

/**
 * The car state screen displaying the state error
 */
@Composable
private fun ErrorScreen(modifier: Modifier = Modifier,retryAction:()->Unit){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.state_error))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.car_state_button))
        }
    }
}

