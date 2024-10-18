package com.example.instagramclone.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.instagramclone.domain.models.Post


@Composable
fun HomeFeedScreen(posts: List<Post>, navController: NavHostController, onLikeClicked: (Post) -> Unit) {
    LazyColumn {
        items(posts.size) { index ->
            PostItem(posts[index], navController, onLikeClicked)
        }
    }
}

@Composable
fun PostItem(post: Post, navController: NavHostController, onLikeClicked: (Post) -> Unit) {
    val isLiked = remember { mutableStateOf(post.isLiked) }
    val likes = remember { mutableStateOf(post.likes.size) }


    Column(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(post.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
        )
        Text(
            text = post.owner.username,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                navController.navigate("profile/${post.owner.id}")
            },
        )
        Text(text = post.caption)
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                isLiked.value = !isLiked.value
                if (isLiked.value) {
                    likes.value++
                } else {
                    likes.value--
                }
                onLikeClicked(post)
            }) {
                Icon(
                    imageVector = if (isLiked.value) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = if (isLiked.value) "Unlike" else "Like"
                )
            }
            Text(text = "${likes.value} likes", modifier = Modifier.padding(end = 8.dp))
        }
        Button(onClick = { navController.navigate("comment/${post.id}") }) {
            Text("Comment")
        }
    }
}
