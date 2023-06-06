package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Icon
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
import com.example.car_integrity_monitor_movile_app.model.CarState

/**
 * The car state screen that loads according to the state of the car state
 * @param modifier
 * @param carStateUiState
 * @param retryAction
 * @return Unit
 */
@Composable
fun CarStateScreen(
    modifier: Modifier = Modifier,
    carStateUiState: CarStateUiState,
    retryAction: () -> Unit
){

        when (carStateUiState) {
            is CarStateUiState.Entry -> {
                Column(modifier = modifier) {
                    Text(
                        text = stringResource(R.string.carstate_title),
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                    EntryScreen(retryAction = retryAction)
                }
            }
            is CarStateUiState.Loading -> LoadingScreen()
            is CarStateUiState.Success -> {
                Column(modifier = modifier) {
                    Text(
                        text = stringResource(R.string.carstate_title),
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                    SuccessScreen(carState = carStateUiState.carState,
                        retryAction = retryAction)
                }
            }
            is CarStateUiState.Error -> {
                Column(modifier = modifier) {
                    Text(
                        text = stringResource(R.string.carstate_title),
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
 * The car state screen displaying the entry message
 * @param modifier
 * @param retryAction
 * @return Unit
 */
@Composable
private fun EntryScreen(modifier: Modifier = Modifier, retryAction: () -> Unit){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column{
            Text(
                text = stringResource(R.string.entry_description),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Button(onClick = retryAction,modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = stringResource(R.string.car_state_button))
            }
        }
    }
}

/**
 * The car state screen displaying the loading message
 * @param modifier
 * @return Unit
 */
@Composable
private fun LoadingScreen(modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.loading_img),
                contentDescription = stringResource(R.string.loading_text),
                modifier = Modifier.size(200.dp)
            )
            Text(text = stringResource(R.string.loading_text),textAlign = TextAlign.Center)
        }
    }
}

/**
 * The car state screen displaying the state information
 * @param modifier
 * @param carState
 * @param retryAction
 * @return Unit
 */
@Composable
private fun SuccessScreen(modifier: Modifier = Modifier,carState: CarState, retryAction: () -> Unit){
    Column(modifier) {
        Grid(modifier = Modifier.fillMaxWidth(),carState = carState)
        Button(onClick = retryAction, modifier = Modifier.align(Alignment.CenterHorizontally)){
            Text(text = stringResource(R.string.car_state_button))
        }
    }
}

/**
 * The car state screen displaying the state error
 * @param modifier
 * @param retryAction
 * @return Unit
 */
@Composable
private fun ErrorScreen(modifier: Modifier = Modifier,retryAction:()->Unit){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.state_error),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = androidx.compose.ui.graphics.Color.Red
        )
        Button(onClick = retryAction) {
            Text(stringResource(R.string.car_state_button))
        }
    }
}

/**
 * Composable function for card showing the text, value and icon passed as parameters
 * @param text the text to be displayed
 * @param value the value to be displayed
 * @param icon the icon to be displayed
 * @param modifier the modifier to be applied to the card
 * @return the card composable
 */
@Composable
private fun Card(text: String, value: String, icon: Int, modifier: Modifier = Modifier){
    androidx.compose.material.Card(
        modifier = modifier.padding(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = icon),
                contentDescription = "Icon",
                modifier = Modifier.size(50.dp)
            )
            Text(text = text, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            Text(text = value)
        }
    }
}

/**
 * Composable function for show cards in a grid with 2 columns
 * @param modifier the modifier to be applied to the grid
 * @return the grid composable
 */
@Composable
private fun Grid(modifier: Modifier = Modifier,carState: CarState){
    val stateCarValues = listOf(
        CarStateToList(stringResource(R.string.speed_title),carState.speed,R.drawable.speed_icon),
        CarStateToList(stringResource(R.string.rpm_title),carState.rpm,R.drawable.speed_icon),
        CarStateToList(stringResource(R.string.temperature_title),carState.engine_temperature,R.drawable.speed_icon),
        CarStateToList(stringResource(R.string.airflow_title),carState.airflow,R.drawable.speed_icon),
        CarStateToList(stringResource(R.string.throttle_title),carState.throttle,R.drawable.speed_icon),
    )

    LazyVerticalGrid(
        modifier = modifier.fillMaxWidth(),
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(stateCarValues.size){
            Card(
                text = stateCarValues[it].name,
                value = stateCarValues[it].value,
                icon = stateCarValues[it].icon
            )
        }
    }
}

data class CarStateToList(
    val name: String,
    val value: String,
    val icon: Int
)