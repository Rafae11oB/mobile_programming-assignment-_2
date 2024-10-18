package com.example.instagramclone.domain.models

data class User(
    val id: Int,
    val username: String,
    val profilePictureUrl: String,
    val bio: String
)