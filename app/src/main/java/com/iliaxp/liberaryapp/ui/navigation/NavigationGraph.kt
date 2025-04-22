package com.iliaxp.liberaryapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iliaxp.liberaryapp.ui.components.AllBooksScreen
import com.iliaxp.liberaryapp.ui.screens.AboutScreen
import com.iliaxp.liberaryapp.ui.screens.CartScreen

import com.iliaxp.liberaryapp.ui.screens.CategoriesScreen
import com.iliaxp.liberaryapp.ui.screens.HistoryBooksScreen
import com.iliaxp.liberaryapp.ui.screens.HomeScreen
import com.iliaxp.liberaryapp.ui.screens.LibraryScreen
import com.iliaxp.liberaryapp.ui.screens.NovelBooksScreen
import com.iliaxp.liberaryapp.ui.screens.ProfileScreen
import com.iliaxp.liberaryapp.ui.screens.ScienceBooksScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("categories") { CategoriesScreen(navController) }
        composable("library") { LibraryScreen(navController) }  // ✅ ارسال NavController
        composable("profile") { ProfileScreen(navController) }  // ✅ ارسال NavController
        composable("about") { AboutScreen(navController) }
        composable("allBooks") { AllBooksScreen(navController) }
        composable("cart") { CartScreen(navController) }
        composable("novelBooks") { NovelBooksScreen(navController) }
        composable("scienceBooks") { ScienceBooksScreen(navController) }
        composable("historyBooks") { HistoryBooksScreen(navController) }
    }
}


