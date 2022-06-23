package com.jvrni.domain.posts.models

import com.jvrni.domain.users.models.User


data class Testimony(
    val id: Int,
    val user: User,
    val description: String
)
