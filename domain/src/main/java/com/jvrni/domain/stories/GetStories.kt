package com.jvrni.domain.stories

import com.jvrni.core.State.Companion.mapper
import com.jvrni.domain.stories.models.Stories
import com.jvrni.domain.users.GetImage
import com.jvrni.domain.users.models.User
import com.jvrni.service.stories.StoriesRepository
import com.jvrni.service.users.models.UserRaw
import javax.inject.Inject

class GetStories @Inject constructor(
    private val repository: StoriesRepository,
    private val getImage: GetImage
) {
    fun execute() = repository.get().mapper { list ->
        list.map { postsRaw ->
            Stories(
                id = postsRaw.id,
                user = postsRaw.user.map(),
            )
        }
    }

    private fun UserRaw.map() = User(
        id = id,
        name = name,
        image = getImage.execute(id),
        genre = genre,
        city = city,
        country = country,
        description = description
    )
}

