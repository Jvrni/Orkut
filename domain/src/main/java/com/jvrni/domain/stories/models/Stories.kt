package com.jvrni.domain.stories.models

import com.jvrni.domain.users.models.User

data class Stories(
    val id: Int,
    val user: User
)
