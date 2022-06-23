package com.jvrni.domain.posts.models

import com.jvrni.domain.users.models.User

data class Posts(
    val id: Int,
    val user: User,
    val testimony: Testimony
)
