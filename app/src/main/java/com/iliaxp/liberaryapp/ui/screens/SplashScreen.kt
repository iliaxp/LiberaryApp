package com.iliaxp.liberaryapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Book Store", fontSize = 32.sp)
            Text(text = "All Of Book You Need.")
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                navController.navigate("home") {
                    popUpTo("splash") { inclusive = true } // جلوگیری از بازگشت به اسپلش
                }
            }) {
                Text("Get Started")
            }
        }
    }
}