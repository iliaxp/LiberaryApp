package com.iliaxp.liberaryapp.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.iliaxp.liberaryapp.R
import com.iliaxp.liberaryapp.models.Book
import com.iliaxp.liberaryapp.ui.components.BookItem
import com.iliaxp.liberaryapp.ui.components.CustomBottomBar
import com.iliaxp.liberaryapp.ui.components.CustomTopAppBar

@Composable
fun HomeScreen(navController: NavController) {
    val books = listOf(
        Book("The Alchemist", "Paulo Coelho", "$15", R.drawable.ic_book),
        Book("1984", "George Orwell", "$12", R.drawable.ic_book),
        Book("To Kill a Mockingbird", "Harper Lee", "$18", R.drawable.ic_book),
        Book("The Great Gatsby", "F. Scott Fitzgerald", "$10", R.drawable.ic_book),
        Book("Moby Dick", "Herman Melville", "$20", R.drawable.ic_book),
        Book("War and Peace", "Leo Tolstoy", "$25", R.drawable.ic_book),
        Book("Pride and Prejudice", "Jane Austen", "$14", R.drawable.ic_book),
        Book("The Catcher in the Rye", "J.D. Salinger", "$17", R.drawable.ic_book),
        Book("Ulysses", "James Joyce", "$22", R.drawable.ic_book),
        Book("Crime and Punishment", "Fyodor Dostoevsky", "$19", R.drawable.ic_book)
    )

    val pagerState = rememberPagerState(pageCount = { 3 })
    val context = LocalContext.current

    Scaffold(
        topBar = { CustomTopAppBar(navController) },
        bottomBar = { CustomBottomBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    val url = when (page) {
                        0 -> "https://g4a4.com/wp-content/uploads/2024/12/File-3.jpg"
                        1 -> "https://g4a4.com/wp-content/uploads/2024/12/File-3.jpg"
                        else -> "https://g4a4.com/wp-content/uploads/2024/12/File-3.jpg"
                    }
                    AsyncImage(
                        model = url,
                        contentDescription = "Category Image",
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                context.startActivity(browserIntent)
                            }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(3) { index ->
                    val color = if (pagerState.currentPage == index) Color(0xFF6851AE) else Color.Gray
                    Box(
                        modifier = Modifier
                            .size(14.dp)
                            .padding(4.dp)
                            .background(color, shape = RoundedCornerShape(50))
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CategoryIconButton(R.drawable.fairytale, "Novel")
                CategoryIconButton(R.drawable.science, "Science")
                CategoryIconButton(R.drawable.history, "History")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(books) { book ->
                    BookItem(book)
                }
            }
        }
    }
}

@Composable
fun CategoryIconButton(drawableId: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = { /* اقدام روی کلیک */ }) {
            Image(
                painter = painterResource(id = drawableId),
                contentDescription = label,
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
            )
        }
        Text(text = label, fontSize = 14.sp, color = Color.Black)
    }
}