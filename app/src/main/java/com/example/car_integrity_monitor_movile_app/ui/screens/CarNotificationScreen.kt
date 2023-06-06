package com.example.car_integrity_monitor_movile_app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.car_integrity_monitor_movile_app.R

/**
 * Composable function that shows the notification screen
 * @param modifier Modifier
 * @param isNotificationActive Boolean
 * @param changeNotificationActiveState Function
 * @return Unit
 */
@Composable
fun CarNotificationScreen(
    modifier: Modifier = Modifier,
    isNotificationActive: Boolean,
    changeNotificationActiveState: () -> Unit
){
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Button(
            onClick = changeNotificationActiveState,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(fontSize = 15.sp,
                text =
            if (isNotificationActive)
                stringResource(id = R.string.notification_deactivate)
            else stringResource(
                id = R.string.notification_activate)
            )
        }
        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                append(stringResource(id = R.string.notification_deactivate))
            }
            append(stringResource(id = R.string.notification_deactivate_description))
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                append(stringResource(id = R.string.notification_activate))
            }
            append(stringResource(id = R.string.notification_activate_description))
        }, modifier = Modifier.padding(top = 16.dp))
        AboutApp()
    }
}

/**
 * Composable function that shows in a column about the app information
 * @param modifier Modifier
 * @return Unit
 */
@Composable
private fun AboutApp(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(bottom = 16.dp),) {
            Icon(
                painter = painterResource(id = R.drawable.ic_info),
                contentDescription = "info",
                modifier = Modifier.size(30.dp).padding(end = 8.dp)
            )
            Text(
                text = stringResource(R.string.about_app_title),
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 20.sp
            )

        }

        Text(
            stringResource(R.string.about_app_description),
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
        )
    }
}

