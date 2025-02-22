package com.iliaxp.liberaryapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.iliaxp.liberaryapp.ui.screens.BookStoreApp

class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookStoreApp()
        }
    }
}