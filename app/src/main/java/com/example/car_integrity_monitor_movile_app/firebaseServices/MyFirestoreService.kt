package com.example.car_integrity_monitor_movile_app.firebaseServices

import android.content.ContentValues.TAG
import android.util.Log
import com.example.car_integrity_monitor_movile_app.model.CarAnomaly
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson

private var db = FirebaseFirestore.getInstance()

private lateinit var anomalies: ArrayList<CarAnomaly>
private var gson = Gson()

/**
 * Save an anomaly in the database
 * @param anomaly String
 * @return Unit
 */
fun saveAnomalyDB(anomaly: String) {

    val document = gson.fromJson(anomaly, HashMap::class.java) as HashMap<String, String>
    db.collection("anomalies")
        .add(document)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }
}

/**
 * Get all anomalies from the database
 * @return ArrayList<CarAnomaly>
 */
fun getAllAnomaliesDB(): ArrayList<CarAnomaly> {
    anomalies = ArrayList()
    db.collection("anomalies")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                val anomaly = document.toObject(CarAnomaly::class.java)
                anomalies.add(anomaly)
            }
        }
        .addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }
    return anomalies
}