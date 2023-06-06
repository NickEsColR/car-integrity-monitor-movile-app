package com.example.car_integrity_monitor_movile_app.ui.screens
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.car_integrity_monitor_movile_app.firebaseServices.getCarState
import com.example.car_integrity_monitor_movile_app.httpServices.requestCarState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CarStateViewModel: ViewModel() {
    var carStateUiState: CarStateUiState by mutableStateOf(CarStateUiState.Entry)
        private set

    /**
     * Gets the car status information and update state
     * @return Unit
     */
    fun getCarStatus(){
        requestCarState()
        viewModelScope.launch {
            carStateUiState = CarStateUiState.Loading
//            carStateUiState = try {
//                CarStateUiState.Success
//            }catch (e: IOException){
//                CarStateUiState.Error
//            }
            var tick = 0
            while(tick<120){
                delay(1000L)
                Log.i("CarStateViewModel", "tick: $tick")
                tick += 1
                val carState = getCarState()
                if(carState != null){
                    Log.i("CarStateViewModel", "state found")
                    carStateUiState = CarStateUiState.Success(carState)
                    tick = 21
                }
            }
            if(tick == 20){
                carStateUiState = CarStateUiState.Error
            }
        }
    }

    /**
     * Factory for CarStateViewModel
     * @return ViewModelProvider.Factoryfa
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CarStateViewModel()
            }
        }
    }
}