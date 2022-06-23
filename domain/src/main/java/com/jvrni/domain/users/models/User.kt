package com.jvrni.domain.users.models

import androidx.annotation.DrawableRes

data class User(
    val id: Int,
    val name: String,
    @DrawableRes val image: Int,
    val genre: String,
    val city: String,
    val country: String,
    val description: String
)