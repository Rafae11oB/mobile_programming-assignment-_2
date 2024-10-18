package com.example.instagramclone.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.instagramclone.domain.models.Post
import com.example.instagramclone.domain.models.User

@Composable
fun ProfileScreen(user: User, posts: List<Post>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(
                user.profilePictureUrl
            ),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(
                    RoundedCornerShape(20.dp)
                )
        )
        Text(
            text = user.username,
            fontWeight = FontWeight.Bold
        )
        Text(text = user.bio)
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(posts.size) { index ->
                Image(
                    painter = rememberAsyncImagePainter(
                        posts[index].imageUrl
                    ),
                    contentDescription = null, modifier = Modifier.size(100.dp),
                )
            }
        }
    }
}