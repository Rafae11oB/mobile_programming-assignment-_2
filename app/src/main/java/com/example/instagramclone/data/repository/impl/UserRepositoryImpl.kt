package com.example.instagramclone.data.repository.impl

import com.example.instagramclone.domain.models.User
import com.example.instagramclone.data.repository.UserRepository

object UserRepositoryImpl : UserRepository {
    private val mockDataHelper = MockDataHelper

    override fun getCurrent(): User = mockDataHelper.currentUser

    override fun getById(id: Int): User {
        println("GET BY USER ID METHOD: $id")
        return mockDataHelper.users.firstOrNull {
            println("USER ID HERE: ${it.id}")
            it.id == id
        }!!
    }

    override fun getAll(): List<User> {
        val allUsers = mockDataHelper.users
        val currentUser = getCurrent()
        return allUsers.filter { it.id != currentUser.id }
    }

    override fun search(query: String): List<User> = getAll().filter {
        it.username.contains(query, ignoreCase = true)
    }
}
