package com.example.instagramclone.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instagramclone.domain.services.NotificationService
import com.example.instagramclone.domain.services.PostService
import com.example.instagramclone.domain.services.UserService

@Composable
fun MainScreen(
    userService: UserService,
    notificationService: NotificationService,
    postService: PostService,
) {
    val navController = rememberNavController()
    val currentActiveUser = userService.getCurrent()
    Scaffold(bottomBar = {
        NavigationBar {
            NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                selected = false,
                onClick = { navController.navigate("home") },
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Search, contentDescription = null) },
                selected = false,
                onClick = { navController.navigate("search") },
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                selected = false,
                onClick = { navController.navigate("addPost") },
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Notifications, contentDescription = null) },
                selected = false,
                onClick = { navController.navigate("notifications") },
            )
            NavigationBarItem(
                icon = { Icon(Icons.Default.Person, contentDescription = null) },
                selected = false,
                onClick = { navController.navigate("profile/${currentActiveUser.id}") },
            )
        }
    }) { innerPadding ->
        NavHost(navController, startDestination = "home", Modifier.padding(innerPadding)) {
            composable("home") {
                HomeFeedScreen(
                    posts = postService.getAll(),
                    navController = navController,
                    onLikeClicked = {
                        postService.changeLike(it.id)
                    }
                )
            }
            composable("search") {
                SearchScreen(
                    initialUsers = userService.getAll(),
                    onSearch = {
                        userService.search(it)
                    },
                    navController = navController,
                )
            }
            composable("addPost") {
                AddPostScreen(
                    onPostAdded = {
                        postService.create(it)
                    },
                )
            }
            composable("notifications") { NotificationsScreen(notifications = notificationService.getAll()) }
            composable("profile/{userId}") { backStackEntry ->
                val userId = backStackEntry.arguments?.getString("userId")?.toInt()
                val currentUser = if (userId == null) {
                    userService.getCurrent()
                } else userService.getById(userId)
                val userPosts = postService.getAllByUserId(currentUser.id)
                ProfileScreen(user = currentUser, posts = userPosts)
            }
            composable("comment/{postId}") { backStackEntry ->
                val postId = backStackEntry.arguments!!.getString("postId")!!.toInt()
                val comments = postService.getPostComments(postId)
                CommentScreen(
                    comments = comments,
                    onCreateComment = {
                        postService.leaveComment(postId, it)
                    },
                )
            }
        }
    }
}
