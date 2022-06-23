package com.jvrni.domain.users

import com.jvrni.domain.users.models.Images
import javax.inject.Inject

class GetImage @Inject constructor() {
    fun execute(id: Int) = Images.values().first { image -> image.id == id }.image
}