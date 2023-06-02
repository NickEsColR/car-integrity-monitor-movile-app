package com.example.car_integrity_monitor_movile_app

import android.content.ClipData
import android.content.ClipboardManager
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.car_integrity_monitor_movile_app.ui.theme.CarintegritymonitormovileappTheme
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //get firebase messaging token and print it to console
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG,"Fetching FCM registration token failed")
                return@addOnCompleteListener
            }
            // Get new FCM registration token
            val token = task.result
            Log.i("Token","FCM registration token: $token")
            // send token to server app
            Log.d(TAG, token)
            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            var clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            var clipData = ClipData.newPlainText("token", token)
            clipboardManager.setPrimaryClip(clipData)
        }
        setContent {
            CarintegritymonitormovileappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CimApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CarintegritymonitormovileappTheme {
        CimApp()
    }
}