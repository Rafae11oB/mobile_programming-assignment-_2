package com.example.instagramclone.data.repository

class UserIdGenerator {
    companion object {
        private var id = 0

        fun generateId(): Int {
            return ++id
        }
    }
}