package com.example.instagramclone.data.repository

import com.example.instagramclone.domain.models.Post

interface PostRepository {
    fun getAll(): List<Post>
    fun create(post: Post)
    fun getAllByUserId(id: Int): List<Post>
    fun getById(id: Int): Post
    fun update(post: Post)
}