package com.iliaxp.liberaryapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iliaxp.liberaryapp.models.Book

@Composable
fun BookItem(book: Book) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.elevatedCardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = book.imageRes),
                contentDescription = book.title,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = book.title, fontSize = 18.sp, color = Color.Black)
                Text(text = book.author, fontSize = 14.sp, color = Color.Gray)
                Text(text = book.price, fontSize = 16.sp, color = Color.Blue)
            }
            Button(onClick = { /* Add to cart logic */ }) {
                Text("Add to Cart")
            }
        }
    }
}