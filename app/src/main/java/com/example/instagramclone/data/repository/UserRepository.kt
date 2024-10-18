package com.example.instagramclone.data.repository

import com.example.instagramclone.domain.models.User

interface UserRepository {
    fun getCurrent(): User
    fun getById(id: Int): User
    fun getAll(): List<User>
    fun search(query: String): List<User>
}