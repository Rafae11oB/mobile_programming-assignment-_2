package com.example.instagramclone.domain.services

import com.example.instagramclone.domain.models.User

interface UserService {
    fun getCurrent(): User
    fun getById(id: Int): User
    fun getAll(): List<User>
    fun search(query: String): List<User>
}