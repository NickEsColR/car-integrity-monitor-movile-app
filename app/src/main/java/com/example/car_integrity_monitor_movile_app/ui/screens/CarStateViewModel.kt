package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
        viewModelScope.launch {
            carStateUiState = CarStateUiState.Loading
            carStateUiState = try {
                CarStateUiState.Success
            }catch (e: IOException){
                CarStateUiState.Error
            }
        }
    }
}