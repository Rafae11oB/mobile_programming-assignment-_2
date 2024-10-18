package com.example.instagramclone.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.instagramclone.data.dto.CreatePostDto

@Composable
fun AddPostScreen(onPostAdded: (CreatePostDto) -> Unit) {
    val caption = remember { mutableStateOf("") }
    val imageUrl = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = imageUrl.value,
            onValueChange = { imageUrl.value = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Enter Image URL...") }
        )
        TextField(
            value = caption.value,
            onValueChange = { caption.value = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Write a caption...") }
        )
        Button(
            onClick = {
                val post = CreatePostDto(
                    imageUrl = imageUrl.value,
                    caption = caption.value,
                )
                if (!post.isValid()) {
                    return@Button
                }
                caption.value = ""
                imageUrl.value = ""
                onPostAdded(post)
            }
        ) {
            Text("Upload")
        }
    }
}