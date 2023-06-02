package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.car_integrity_monitor_movile_app.httpServices.requestCarState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

class CarStateViewModel: ViewModel() {
    var carStateUiState: CarStateUiState by mutableStateOf(CarStateUiState.Entry)
        private set

    /**
     * Gets the car status information and update state
     * Currently version just change status without information
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

            delay(10000L)
            carStateUiState = CarStateUiState.Success
        }
    }

    /**
     * Factory for CarStateViewModel
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CarStateViewModel()
            }
        }
    }
}