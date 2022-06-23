package com.jvrni.service.posts.models

import com.jvrni.service.users.models.UserRaw

data class TestimonyRaw(
    val id: Int,
    val user: UserRaw,
    val description: String
)