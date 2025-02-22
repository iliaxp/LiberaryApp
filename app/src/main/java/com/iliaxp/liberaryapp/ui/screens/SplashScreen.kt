package com.iliaxp.liberaryapp.ui.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iliaxp.liberaryapp.R

@Composable
fun SplashScreen(navController: NavController, context: Context) {
    val sharedPreferences = remember { context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE) }
    val isFirstLaunch = remember { mutableStateOf(sharedPreferences.getBoolean("is_first_launch", true)) }

    LaunchedEffect(Unit) {  // حل مشکل رندر بی‌نهایت
        if (!isFirstLaunch.value) {
            navController.navigate("home") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    if (isFirstLaunch.value) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Book Store", fontSize = 32.sp)
                Text(text = "All Of Book You Need.")
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    sharedPreferences.edit().putBoolean("is_first_launch", false).apply()
                    isFirstLaunch.value = false
                    navController.navigate("home") {
                        popUpTo("splash") { inclusive = true }
                    }
                }) {
                    Text("Get Started")
                }
            }
        }
    }
}
