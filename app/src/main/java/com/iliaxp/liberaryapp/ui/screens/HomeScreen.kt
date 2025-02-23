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

    val pagerState = rememberPagerState(pageCount = { 3 })
    val context = LocalContext.current

    Scaffold(
        topBar = { CustomTopAppBar(navController) },
        bottomBar = { CustomBottomBar(navController) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(horizontal = 20.dp) // اضافه کردن padding به چپ و راست
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
            }
            items(books) { book ->
                BookItem(book)
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