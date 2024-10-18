package com.example.instagramclone.domain.models

enum class NotificationType {
    LIKE,
    COMMENT,
    FOLLOW,
}

data class Notification(
    val user: User,
    val notificationType: NotificationType,
    val executor: User,
) {
    override fun toString(): String = when (notificationType) {
        NotificationType.FOLLOW -> "${executor.username} started following you"
        NotificationType.LIKE -> "${executor.username} liked your post"
        NotificationType.COMMENT -> "${executor.username} commented on your post"
    }
}