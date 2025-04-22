package com.iliaxp.liberaryapp.ui.screens

import android.annotation.SuppressLint
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.iliaxp.liberaryapp.ui.components.CustomBottomBar
import com.iliaxp.liberaryapp.ui.components.CustomTopAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScienceBooksScreen(navController: NavController) {
    Scaffold(
        topBar = { CustomTopAppBar(navController) },
        bottomBar = { CustomBottomBar(navController) }
    ) { innderPadding ->

    }

}