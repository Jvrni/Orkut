package com.jvrni.service.stories.models

import com.jvrni.service.users.models.UserRaw

data class StoriesRaw(
    val id: Int,
    val user: UserRaw
)