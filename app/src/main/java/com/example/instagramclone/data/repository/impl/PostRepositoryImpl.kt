package com.example.instagramclone.data.repository.impl

import com.example.instagramclone.data.repository.PostRepository
import com.example.instagramclone.domain.models.Post

object PostRepositoryImpl : PostRepository {
    private val mockDataHelper = MockDataHelper

    override fun getAll(): List<Post> = mockDataHelper.posts.sortedByDescending { it.createdAt }

    override fun create(post: Post) {
        mockDataHelper.posts.add(post)
    }

    override fun getAllByUserId(id: Int): List<Post> = mockDataHelper.posts.filter {
        it.owner.id == id
    }.sortedByDescending { it.createdAt }

    override fun getById(id: Int): Post = mockDataHelper.posts.find {
        it.id == id
    }!!

    override fun update(post: Post) {
        val posts = mockDataHelper.posts
        for (i in posts.indices) {
            if (posts[i].id == post.id) {
                posts[i] = post
            }
        }
    }
}