package com.example.instagramclone.domain.models

import java.time.LocalDateTime

data class Post(
    val id: Int,
    val owner: User,
    val imageUrl: String,
    val caption: String,
    val likes: MutableList<Int>,
    val comments: MutableList<Comment>,
    val isLiked: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now(),
)