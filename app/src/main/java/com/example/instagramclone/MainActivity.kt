package com.example.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.instagramclone.data.repository.impl.NotificationRepositoryImpl
import com.example.instagramclone.data.repository.impl.PostRepositoryImpl
import com.example.instagramclone.data.repository.impl.UserRepositoryImpl
import com.example.instagramclone.domain.services.UserService
import com.example.instagramclone.domain.services.impl.NotificationServiceImpl
import com.example.instagramclone.domain.services.impl.PostServiceImpl
import com.example.instagramclone.domain.services.impl.UserServiceImpl
import com.example.instagramclone.ui.screens.MainScreen
import com.example.instagramclone.ui.theme.InstagramCloneTheme

class MainActivity : ComponentActivity() {
    private val userRepository = UserRepositoryImpl
    private val postRepository = PostRepositoryImpl
    private val notificationRepository = NotificationRepositoryImpl

    private val userService = UserServiceImpl(
        userRepository = userRepository
    )
    private val postService = PostServiceImpl(
        postRepository = postRepository,
        userRepository = userRepository,
        notificationRepository = notificationRepository
    )
    private val notificationService = NotificationServiceImpl(
        userRepository = userRepository,
        notificationRepository = notificationRepository
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstagramCloneTheme {
                MainScreen(
                    userService = userService,
                    notificationService = notificationService,
                    postService = postService
                )
            }
        }
    }
}
