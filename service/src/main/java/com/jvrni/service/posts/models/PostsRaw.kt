package com.jvrni.service.posts.models

import com.jvrni.service.users.models.UserRaw

data class PostsRaw(
    val id: Int,
    val user: UserRaw,
    val testimony: TestimonyRaw
)