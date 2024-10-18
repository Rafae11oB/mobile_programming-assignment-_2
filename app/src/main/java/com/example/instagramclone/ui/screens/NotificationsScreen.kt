package com.example.instagramclone.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.instagramclone.domain.models.Notification

@Composable
fun NotificationsScreen(notifications: List<Notification>) {
    LazyColumn {
        items(notifications.size) { index ->
            NotificationItem(notifications[index])
        }
    }
}

@Composable
fun NotificationItem(notification: Notification) {
    Text(text = notification.toString(), modifier = Modifier.padding(8.dp))
}