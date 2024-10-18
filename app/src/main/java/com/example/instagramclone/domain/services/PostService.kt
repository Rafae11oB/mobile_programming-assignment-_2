package com.example.instagramclone.domain.services

import com.example.instagramclone.data.dto.CreatePostDto
import com.example.instagramclone.domain.models.Comment
import com.example.instagramclone.domain.models.Post

interface PostService {
    fun getAll(): List<Post>
    fun create(post: CreatePostDto)
    fun getAllByUserId(id: Int): List<Post>
    fun leaveComment(id: Int, comment: String)
    fun changeLike(id: Int)
    fun getPostComments(id: Int): List<Comment>
}