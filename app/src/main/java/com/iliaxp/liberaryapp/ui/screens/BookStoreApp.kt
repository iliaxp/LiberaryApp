package com.iliaxp.liberaryapp.ui.screens

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iliaxp.liberaryapp.ui.components.AllBooksScreen

@Composable
fun BookStoreApp() {
    val navController = rememberNavController()
    val context = LocalContext.current  // مقداردهی ایمن

    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController, context) }
        composable("home") { HomeScreen(navController) }
        composable("categories") { CategoriesScreen(navController) }
        composable("library") { LibraryScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
        composable("about") { AboutScreen(navController) }
        composable("allBooks") { AllBooksScreen(navController) }
        composable("cart") { CartScreen(navController) }
        composable("novelBooks") { NovelBooksScreen(navController) }
        composable("scienceBooks") { ScienceBooksScreen(navController) }
        composable("historyBooks") { HistoryBooksScreen(navController) }
    }
}
