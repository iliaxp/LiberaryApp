package com.iliaxp.liberaryapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.iliaxp.liberaryapp.ui.components.CustomBottomBar
import com.iliaxp.liberaryapp.ui.components.CustomTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HistoryBooksScreen(navController: NavController) {
    Scaffold(
        topBar = { CustomTopAppBar(navController) },
        bottomBar = { CustomBottomBar(navController) }
    ) {
        // your content with Modifier.padding(innerPadding)
    }

}