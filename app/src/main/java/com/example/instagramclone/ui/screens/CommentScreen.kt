package com.example.instagramclone.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.instagramclone.domain.models.Comment


@Composable
fun CommentScreen(comments: List<Comment>, onCreateComment: (String) -> Unit) {
    val comment = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(comments.size) { index ->
                CommentItem(comments[index])
            }
        }
        TextField(
            value = comment.value,
            onValueChange = { comment.value = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Write a comment...") }
        )
        Button(onClick = {
            if (comment.value.isNotEmpty()) {
                onCreateComment(comment.value)
            }
        }) {
            Text("Submit Comment")
        }
    }
}

@Composable
fun CommentItem(comment: Comment) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(
                comment.owner.profilePictureUrl
            ), contentDescription = null, modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = comment.owner.username, fontWeight = FontWeight.Bold)
            Text(text = comment.text)
        }
    }
}
