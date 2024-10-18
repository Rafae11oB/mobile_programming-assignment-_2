package com.example.instagramclone.data.repository.impl

import com.example.instagramclone.data.repository.PostIdGenerator
import com.example.instagramclone.data.repository.UserIdGenerator
import com.example.instagramclone.domain.models.Comment
import com.example.instagramclone.domain.models.Notification
import com.example.instagramclone.domain.models.NotificationType
import com.example.instagramclone.domain.models.Post
import com.example.instagramclone.domain.models.User

object MockDataHelper {
    val currentUser = User(
        id = UserIdGenerator.generateId(),
        username = "currentUser",
        profilePictureUrl = "https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small_2x/profile-icon-design-free-vector.jpg",
        bio = "Lover of nature and photography."
    )

    val users = listOf(
        currentUser,
        User(
            id = UserIdGenerator.generateId(),
            username = "user1",
            profilePictureUrl = "https://static.vecteezy.com/system/resources/previews/003/715/527/non_2x/picture-profile-icon-male-icon-human-or-people-sign-and-symbol-vector.jpg",
            bio = "Lover of nature and photography."
        ),
        User(
            id = UserIdGenerator.generateId(),
            username = "user2",
            profilePictureUrl = "https://cdn.pixabay.com/photo/2019/08/11/18/59/icon-4399701_1280.png",
            bio = "Travel enthusiast."
        ),
        User(
            id = UserIdGenerator.generateId(),
            username = "user3",
            profilePictureUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0JVBsxKIFPFiJFW2PXbBUlvs20CXJIVtc4A&s",
            bio = "Foodie and adventurer."
        )
    )

    val posts = mutableListOf(
        Post(
            id = PostIdGenerator.generateId(),
            owner = currentUser,
            imageUrl = "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
            caption = "Beautiful day!",
            likes = mutableListOf(3),
            comments = mutableListOf()
        ),
        Post(
            id = PostIdGenerator.generateId(),
            owner = currentUser,
            imageUrl = "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
            caption = "Loving the vibes.",
            likes = mutableListOf(3),
            comments = mutableListOf()
        ),
        Post(
            id = PostIdGenerator.generateId(),
            owner = currentUser,
            imageUrl = "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg",
            caption = "Loving the vibes.",
            likes = mutableListOf(3),
            comments = mutableListOf()
        ),
        Post(
            id = PostIdGenerator.generateId(),
            owner = users[1],
            imageUrl = "https://fps.cdnpk.net/images/home/subhome-ai.webp?w=649&h=649",
            caption = "Beautiful day!",
            likes = mutableListOf(3),
            comments = mutableListOf()
        ),
        Post(
            id = PostIdGenerator.generateId(),
            owner = users[2],
            imageUrl = "https://images.ctfassets.net/hrltx12pl8hq/28ECAQiPJZ78hxatLTa7Ts/2f695d869736ae3b0de3e56ceaca3958/free-nature-images.jpg?fit=fill&w=1200&h=630",
            caption = "Loving the vibes.",
            likes = mutableListOf(3),
            comments = mutableListOf()
        ),
        Post(
            id = PostIdGenerator.generateId(),
            owner = users[3],
            imageUrl = "https://i0.wp.com/picjumbo.com/wp-content/uploads/beautiful-nature-mountain-scenery-with-flowers-free-photo.jpg?w=600&quality=80",
            caption = "Loving the vibes.",
            likes = mutableListOf(3),
            comments = mutableListOf()
        ),
        Post(
            id = PostIdGenerator.generateId(),
            owner = users[3],
            imageUrl = "https://i0.wp.com/picjumbo.com/wp-content/uploads/beautiful-nature-mountain-scenery-with-flowers-free-photo.jpg?w=600&quality=80",
            caption = "Chillin' out here.",
            likes = mutableListOf(3),
            comments = mutableListOf()
        )
    )

    val notifications = mutableListOf(
        Notification(
            user = currentUser,
            executor = users[1],
            notificationType = NotificationType.LIKE
        ),
        Notification(
            user = currentUser,
            executor = users[2],
            notificationType = NotificationType.FOLLOW
        ),
        Notification(
            user = currentUser,
            executor = users[3],
            notificationType = NotificationType.COMMENT,
        )
    )

    init {
        posts.forEach {
            it.comments.add(
                Comment(
                    text = "Nice view",
                    owner = users[2],
                )
            )
        }
    }
}