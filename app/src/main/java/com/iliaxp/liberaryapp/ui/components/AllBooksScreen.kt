package com.iliaxp.liberaryapp.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iliaxp.liberaryapp.models.Book

@SuppressLint("SuspiciousIndentation", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AllBooksScreen(navController: NavController) {

    val books = listOf(
        Book("The Alchemist", "Paulo Coelho", "$15", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg"),
        Book("1984", "George Orwell", "$12", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg"),
        Book("To Kill a Mockingbird", "Harper Lee", "$18", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg"),
        Book("The Great Gatsby", "F. Scott Fitzgerald", "$10", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg"),
        Book("Moby Dick", "Herman Melville", "$20", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg"),
        Book("War and Peace", "Leo Tolstoy", "$25", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg"),
        Book("Pride and Prejudice", "Jane Austen", "$14", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg"),
        Book("The Catcher in the Rye", "J.D. Salinger", "$17", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg"),
        Book("Ulysses", "James Joyce", "$22", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg"),
        Book("Crime and Punishment", "Fyodor Dostoevsky", "$19", "https://www.fadakbook.ir/storage/uploads/product/lg_b8e94_ketab_tekehayi_az_yek_kol_mons.jpg")
    )

    Scaffold (
        topBar = { CustomTopAppBar(navController) },
        bottomBar = { CustomBottomBar(navController) }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            items(books) { book ->
                BookItem(book)
            }
        }
    }
}