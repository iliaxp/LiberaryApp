package com.iliaxp.liberaryapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.iliaxp.liberaryapp.ui.components.CustomBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var isSearching by remember { mutableStateOf(false) }
    val pagerState = rememberPagerState(pageCount = { 3 })
    val coroutineScope = rememberCoroutineScope()
    var searchText by remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BookPoint") },
                actions = {
                    IconButton(onClick = { isSearching = !isSearching }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    }
                },
                modifier = Modifier.padding(top = 8.dp) // فاصله از استاتوس بار
            )
        },
        bottomBar = { CustomBottomBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // اعمال فاصله برای جلوگیری از همپوشانی
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    AsyncImage(
                        model = when (page) {
                            0 -> "https://via.placeholder.com/600x300"  // لینک تستی
                            1 -> "https://via.placeholder.com/600x300/FF5733"
                            else -> "https://via.placeholder.com/600x300/33FF57"
                        },
                        contentDescription = "Category Image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 📌 دایره‌های نشانگر اسلایدر
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(3) { index ->
                    val color =
                        if (pagerState.currentPage == index) Color(0xFF6851AE) else Color.Gray
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .padding(4.dp)
                            .background(color, shape = RoundedCornerShape(50))
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 📌 3 دکمه آیکونی برای دسته‌بندی کتاب‌ها
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CategoryIconButton("https://via.placeholder.com/60", "Novel")
                CategoryIconButton("https://via.placeholder.com/60", "Science")
                CategoryIconButton("https://via.placeholder.com/60", "History")
            }
        }
    }
}


@Composable
fun CategoryIconButton(imageUrl: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = { /* اقدام روی کلیک */ }) {
            AsyncImage(
                model = imageUrl,
                contentDescription = label,
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(12.dp))
                    .padding(8.dp)
            )
        }
        Text(text = label, fontSize = 14.sp, color = Color.Black)
    }
}