package com.example.instagramclone.data.repository

import com.example.instagramclone.domain.models.Notification

interface NotificationRepository {
    fun getAll(userId: Int): List<Notification>
    fun save(notification: Notification)
}