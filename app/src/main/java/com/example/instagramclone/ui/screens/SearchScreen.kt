package com.example.instagramclone.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.instagramclone.domain.models.User

@Composable
fun SearchScreen(initialUsers: List<User>, onSearch: (String) -> List<User>, navController: NavHostController) {
    val query = remember { mutableStateOf("") }
    val users = remember { mutableStateOf(initialUsers) }

    Column {
        TextField(
            value = query.value,
            onValueChange = {
                query.value = it
                users.value = if (query.value.isEmpty()) {
                    initialUsers
                } else onSearch(it)
            },
            modifier = Modifier.fillMaxWidth(), placeholder = { Text("Search") },
        )
        LazyColumn {
            items(users.value.size) { index ->
                UserItem(users.value[index], navController)
            }
        }
    }
}

@Composable
fun UserItem(user: User, navController: NavHostController) {
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
            navController.navigate("profile/${user.id}")
        }) {
        Image(
            painter = rememberAsyncImagePainter(model = user.profilePictureUrl),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Text(text = user.username, modifier = Modifier.padding(start = 8.dp))
    }
}