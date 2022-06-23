package com.jvrni.service.posts

import android.content.Context
import com.jvrni.core.State
import com.jvrni.core.State.Companion.request
import com.jvrni.service.R
import com.jvrni.service.posts.models.PostsRaw
import com.jvrni.service.toList
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsRepository @Inject constructor(
    private val context: Context,
    private val moshi: Moshi
) {
    fun get(): Flow<State<List<PostsRaw>>> = request { moshi.toList(context, R.raw.posts) }
}