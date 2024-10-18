package com.example.instagramclone.data.dto

class CreatePostDto(
    val imageUrl: String,
    val caption: String,
) {
    fun isValid() = imageUrl.isNotEmpty() && caption.isNotEmpty()
}