package com.iliaxp.liberaryapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.iliaxp.liberaryapp.models.Book
import com.iliaxp.liberaryapp.ui.components.BookItem
import com.iliaxp.liberaryapp.ui.components.CustomBottomBar
import com.iliaxp.liberaryapp.ui.components.CustomTopAppBar

@Composable
fun NovelBooksScreen(navController: NavController) {
    val books = listOf(
        Book("The Old Man and The Sea", "Ernest Hemingway", "$15", "https://zabanmehrpub.com/wp-content/uploads/the-old-man-and-the-sea-1-1.jpg"),
        Book("Atomic Habits", "James Clear", "$12", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg")
    )

    Scaffold(
        topBar = { CustomTopAppBar(navController) },
        bottomBar = { CustomBottomBar(navController) }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(books) { book ->
                BookItem(book)
            }
        }
    }
}