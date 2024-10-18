package com.example.instagramclone.domain.services

import com.example.instagramclone.domain.models.Notification

interface NotificationService {
    fun getAll(): List<Notification>
}