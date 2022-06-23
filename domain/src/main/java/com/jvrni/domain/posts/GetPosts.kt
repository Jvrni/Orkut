package com.jvrni.domain.posts

import com.jvrni.core.State.Companion.mapper
import com.jvrni.domain.posts.models.Posts
import com.jvrni.domain.posts.models.Testimony
import com.jvrni.domain.users.GetImage
import com.jvrni.domain.users.models.User
import com.jvrni.service.posts.PostsRepository
import com.jvrni.service.users.models.UserRaw
import javax.inject.Inject

class GetPosts @Inject constructor(
    private val repository: PostsRepository,
    private val getImage: GetImage
) {
    fun execute() = repository.get().mapper { list ->
        list.map { postsRaw ->
            Posts(
                id = postsRaw.id,
                user = postsRaw.user.map(),
                testimony = Testimony(
                    id = postsRaw.testimony.id,
                    user = postsRaw.testimony.user.map(),
                    description = postsRaw.testimony.description
                )
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

