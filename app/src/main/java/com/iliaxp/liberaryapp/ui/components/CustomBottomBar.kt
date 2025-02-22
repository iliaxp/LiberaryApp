package com.iliaxp.liberaryapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CustomBottomBar(navController: NavController) {
    val items = listOf(
        "home" to Icons.Filled.Home,
        "categories" to Icons.AutoMirrored.Filled.List,
        "library" to Icons.Filled.MoreVert,
        "profile" to Icons.Filled.Person
    )

    var selectedItem by remember { mutableStateOf("home") }

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White
    ) {
        items.forEach { (route, icon) ->
            NavigationBarItem(
                selected = selectedItem == route,
                onClick = {
                    selectedItem = route
                    navController.navigate(route) {
                        popUpTo("home") { inclusive = false }
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = route,
                        tint = if (selectedItem == route) Color(0xFF6851AE) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = route.replaceFirstChar { it.uppercase() },
                        fontSize = 12.sp,
                        color = if (selectedItem == route) Color(0xFF6851AE) else Color.Gray
                    )
                }
            )
        }
    }
}