package com.example.car_integrity_monitor_movile_app.httpServices

import android.util.Log
import fuel.Fuel
import fuel.get
import kotlinx.coroutines.runBlocking

private const val urlRequestCarState = "pasteurlhere"
private const val urlChangeSendAlarm = "pasteurlhere"

/**
 * Requests the car state to the AWS server
 * @return Unit
 */
fun requestCarState(){
    Log.i("httpAWS", "requestCarState")
    runBlocking {
        val string = Fuel.get(urlRequestCarState).body
        println(string)
    }
}

/**
 * Changes the send alarm flag of the IoT device
 * @return Unit
 */
fun changeSendAlarm(){
    Log.i("httpAWS", "changeSendAlarms")
    runBlocking {
        val string = Fuel.get(urlChangeSendAlarm).body
        println(string)
    }
}