package com.example.car_integrity_monitor_movile_app.firebaseServices

import android.content.ContentValues.TAG
import android.util.Log
import com.example.car_integrity_monitor_movile_app.model.CarAnomaly
import com.google.firebase.firestore.FirebaseFirestore

var db = FirebaseFirestore.getInstance()

private lateinit var anomalies: ArrayList<CarAnomaly>

fun saveAnomalyDB(anomaly: String) {
    val document = hashMapOf(
        "anomaly" to anomaly
    )
    db.collection("anomalies")
        .add(document)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }
}

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