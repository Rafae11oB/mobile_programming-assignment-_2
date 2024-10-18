package com.example.instagramclone.domain.services.impl

import com.example.instagramclone.data.repository.NotificationRepository
import com.example.instagramclone.data.repository.UserRepository
import com.example.instagramclone.domain.models.Notification
import com.example.instagramclone.domain.services.NotificationService

class NotificationServiceImpl(
    private val userRepository: UserRepository,
    private val notificationRepository: NotificationRepository
) : NotificationService {
    override fun getAll(): List<Notification> {
        val currentUser = userRepository.getCurrent()
        return notificationRepository.getAll(currentUser.id)
    }
}