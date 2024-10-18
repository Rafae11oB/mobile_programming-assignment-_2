package com.example.instagramclone.domain.services.impl

import com.example.instagramclone.data.dto.CreatePostDto
import com.example.instagramclone.data.repository.NotificationRepository
import com.example.instagramclone.data.repository.PostIdGenerator
import com.example.instagramclone.data.repository.PostRepository
import com.example.instagramclone.data.repository.UserRepository
import com.example.instagramclone.domain.models.Comment
import com.example.instagramclone.domain.models.Notification
import com.example.instagramclone.domain.models.NotificationType
import com.example.instagramclone.domain.models.Post
import com.example.instagramclone.domain.services.PostService

class PostServiceImpl(
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
    private val notificationRepository: NotificationRepository,
) : PostService {
    override fun getAll(): List<Post> {
        val posts = postRepository.getAll()
        val currentUser = userRepository.getCurrent()
        return posts.map {
            it.copy(
                isLiked = it.likes.contains(currentUser.id)
            )
        }
    }

    override fun create(post: CreatePostDto) {
        val currentUser = userRepository.getCurrent()
        val newPost = Post(
            id = PostIdGenerator.generateId(),
            owner = currentUser,
            imageUrl = post.imageUrl,
            caption = post.caption,
            likes = mutableListOf(),
            comments = mutableListOf()
        )
        postRepository.create(newPost)
    }

    override fun getAllByUserId(id: Int): List<Post> {
        val posts = postRepository.getAllByUserId(id)
        val currentUser = userRepository.getCurrent()
        return posts.map {
            it.copy(
                isLiked = it.likes.contains(currentUser.id)
            )
        }
    }

    override fun leaveComment(id: Int, comment: String) {
        val currentUser = userRepository.getCurrent()
        val commentModel = Comment(
            text = comment,
            owner = currentUser
        )
        val post = postRepository.getById(id)
        post.comments.add(commentModel)
        postRepository.update(post)

        val notification = Notification(
            notificationType = NotificationType.COMMENT,
            executor = currentUser,
            user = post.owner
        )
        notificationRepository.save(notification)
    }

    override fun changeLike(id: Int) {
        val currentUser = userRepository.getCurrent()
        val post = postRepository.getById(id)
        if (post.likes.contains(currentUser.id)) {
            post.likes.remove(currentUser.id)
        } else {
            post.likes.add(currentUser.id)
        }
        postRepository.update(post)

        val notification = Notification(
            notificationType = NotificationType.LIKE,
            executor = currentUser,
            user = post.owner
        )
        notificationRepository.save(notification)
    }

    override fun getPostComments(id: Int): List<Comment> {
        val post = postRepository.getById(id)
        return post.comments
    }
}