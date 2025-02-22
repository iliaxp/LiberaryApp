package com.iliaxp.liberaryapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CustomTopAppBar(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    var isSearchActive by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
            .background(Color(0xFF6851AE)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                IconButton(onClick = { expanded = true }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Home") },
                        onClick = {
                            navController.navigate("home")
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("About") },
                        onClick = {
                            navController.navigate("about")
                            expanded = false
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // If search is active, show the search bar
            if (isSearchActive) {
                SearchBar(searchQuery = searchQuery, onSearchQueryChanged = { searchQuery = it }, onSearchClose = { isSearchActive = false })
            } else {
                Text(text = "Home", fontSize = 18.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.weight(1f))

            // IconButton to trigger the search
            IconButton(onClick = { isSearchActive = !isSearchActive }) {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
            }
        }
    }
}

@Composable
fun SearchBar(searchQuery: String, onSearchQueryChanged: (String) -> Unit, onSearchClose: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        TextField(
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            placeholder = { Text(text = "Search...", color = Color.Gray) },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "Search Icon", tint = Color.Gray)
            },
            trailingIcon = {
                IconButton(onClick = onSearchClose) {
                    Icon(Icons.Default.Close, contentDescription = "Close Search", tint = Color.Gray)
                }
            },
            singleLine = true
        )
    }
}
