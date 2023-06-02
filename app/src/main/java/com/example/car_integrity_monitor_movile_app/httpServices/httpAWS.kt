package com.example.car_integrity_monitor_movile_app.httpServices

import khttp.get
import android.util.Log
import fuel.Fuel
import fuel.get
import kotlinx.coroutines.runBlocking

private const val url = "*"

fun requestCarState(){
    Log.i("httpAWS", "requestCarState")
    runBlocking {
        val string = Fuel.get(url).body!!
        println(string)
    }

}