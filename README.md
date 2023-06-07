# car-integrity-monitor-movile-app
This is the code for the Android App implementation of the Grade Project, presented at **ICESI** University by **Nicolas Colmenares** title "Sistema de TI para el monitoreo 
y gestión de los datos generados por la ECU y la alarma de automoviles".

This code is develop with Android Studio IDE using Kotlin and Jetpack Compose. The information is presented in 3 screens: State, Anomaly and notifications.
The app conects with Firebase services Firestore to save and load information and FCM to manage push notifications, both classes are inside firebaseService package.
It also has a httpService package with a kotlin file that enable connection using https to execute an AWS Lambda function using AWS API Gateway.
For the State screen the user request the car state, which use the https connection to advice the device that data is needed. For Anomaly screen shows the saved anomalies
in firebase. For notification screen shows a button to activate and deactivate notifications, and present information related to the notifications and the app itself.

For security resons the url connections has been removed from the https service, also it does not contains the firebase service json file that enables the connections with
Firebase project use for the solution.

Since the project covers microcontroller and cloud services implementation, the code related to this tasks can be found in other GitHub repositories

# Files deleted to security reasons
- urls of API Gateway
- Firebase service json file

# Repository for microcontroller for ESP32
[Github repository with microcontroller code for the project](https://github.com/NickEsColR/car-integrity-monitor-arduino/)

# Repository for cloud services implementation using python functions
[Github repository with python code for the project](https://github.com/NickEsColR/car-integrity-monitor-lambda-functions/)
