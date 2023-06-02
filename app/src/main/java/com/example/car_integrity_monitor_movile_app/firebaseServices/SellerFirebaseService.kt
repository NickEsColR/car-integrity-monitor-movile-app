package com.example.car_integrity_monitor_movile_app.firebaseServices
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Override base class methods to handle any events required by the application.
 * All methods are invoked on a background thread, and may be called when the app is in the background or not open.
 *
 *  The registration token may change when:
 *  - The app deletes Instance ID
 *  - The app is restored on a new device
 *  - The user uninstalls/reinstall the app
 *  - The user clears app data.
 */
class SellerFirebaseService : FirebaseMessagingService() {

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("SellerFirebaseService ", "Refreshed token :: $token")
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String) {

    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.i("SellerFirebaseService ", "Message :: $remoteMessage")

        val body = remoteMessage.notification?.body
        val title  = remoteMessage.notification?.title
        //create notification to display
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(baseContext, "$title $body", Toast.LENGTH_SHORT).show()
        }
        if(body!=null){
            if (title?.equals("Anomalia detectada")==true) {
                //print in console
                println("Anomaly detected")
                saveAnomalyDB(body)
            }else if(title?.equals("Scanner")==true){
                //load scanner data in car state repository

            }
        }

    }
}