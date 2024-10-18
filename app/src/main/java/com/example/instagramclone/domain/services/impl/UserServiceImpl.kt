package com.example.instagramclone.domain.services.impl

import com.example.instagramclone.data.repository.UserRepository
import com.example.instagramclone.domain.models.User
import com.example.instagramclone.domain.services.UserService

class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {
    override fun getCurrent(): User = userRepository.getCurrent()

    override fun getById(id: Int): User = userRepository.getById(id)

    override fun getAll(): List<User> = userRepository.getAll()

    override fun search(query: String): List<User> = userRepository.search(query)
}