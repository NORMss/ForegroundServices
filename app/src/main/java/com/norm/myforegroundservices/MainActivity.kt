package com.norm.myforegroundservices

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.norm.myforegroundservices.ui.theme.MyForegroundServicesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }
        setContent {
            MyForegroundServicesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            onClick = {
                                Intent(applicationContext, RunningService::class.java).also {
                                    it.action = RunningService.Actions.START.toString()
                                    startService(it)
                                }
                            }
                        ) {
                            Text(
                                text = "Start Notification"
                            )
                        }
                        Button(
                            onClick = {
                                Intent(applicationContext, RunningService::class.java).also {
                                    it.action = RunningService.Actions.STOP.toString()
                                    startService(it)
                                }
                            }
                        ) {
                            Text(
                                text = "Stop Notification"
                            )
                        }
                    }
                }
            }
        }
    }
}