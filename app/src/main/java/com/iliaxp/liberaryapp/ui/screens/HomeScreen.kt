package com.iliaxp.liberaryapp.ui.screens

import android.content.Intent
import android.net.Uri

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.iliaxp.liberaryapp.R
import com.iliaxp.liberaryapp.ui.components.CustomBottomBar
import com.iliaxp.liberaryapp.ui.components.CustomTopAppBar

@Composable
fun HomeScreen(navController: NavController) {


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
                    .fillMaxWidth() // بازگرداندن اسلایدر به حالت قبل
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