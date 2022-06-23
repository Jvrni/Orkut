package com.jvrni.domain.users

import com.jvrni.core.State.Companion.mapper
import com.jvrni.domain.users.models.User
import com.jvrni.service.users.UserRepository
import javax.inject.Inject

class GetUser @Inject constructor(
    private val repository: UserRepository,
    private val getImage: GetImage
){

    fun execute(id: Int) = repository.get(id).mapper { userRaw ->
        User(
            id = userRaw.id,
            name = userRaw.name,
            image = getImage.execute(userRaw.id),
            genre = userRaw.genre,
            city = userRaw.city,
            country = userRaw.country,
            description = userRaw.description
        )
    }
}