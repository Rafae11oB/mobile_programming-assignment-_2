package com.example.instagramclone.data.repository.impl

import com.example.instagramclone.domain.models.Notification
import com.example.instagramclone.data.repository.NotificationRepository

object NotificationRepositoryImpl : NotificationRepository {
    private val mockDataHelper = MockDataHelper

    override fun getAll(userId: Int): List<Notification> = mockDataHelper.notifications.filter {
        it.user.id == userId
    }

    override fun save(notification: Notification) {
        mockDataHelper.notifications.add(notification)
    }
}