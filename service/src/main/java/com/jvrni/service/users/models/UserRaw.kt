package com.jvrni.service.users.models

data class UserRaw(
    val id: Int,
    val name: String,
    val genre: String,
    val city: String,
    val country: String,
    val description: String
)