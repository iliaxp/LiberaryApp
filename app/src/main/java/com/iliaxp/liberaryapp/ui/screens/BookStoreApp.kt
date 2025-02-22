package com.iliaxp.liberaryapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun BookStoreApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("categories") { CategoriesScreen(navController) }
        composable("library") { LibraryScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("about") { AboutScreen(navController) }
    }
}
