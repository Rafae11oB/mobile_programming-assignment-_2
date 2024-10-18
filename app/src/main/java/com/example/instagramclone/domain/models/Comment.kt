package com.example.instagramclone.domain.models

import java.time.LocalDateTime

class Comment(
    val text: String,
    val owner: User,
    val createdAt: LocalDateTime = LocalDateTime.now()
)