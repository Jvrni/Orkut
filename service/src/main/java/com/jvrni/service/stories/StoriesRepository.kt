package com.jvrni.service.stories

import android.content.Context
import com.jvrni.core.State
import com.jvrni.service.R
import com.jvrni.service.stories.models.StoriesRaw
import com.jvrni.service.toList
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StoriesRepository @Inject constructor(
    private val context: Context,
    private val moshi: Moshi
) {
    fun get(): Flow<State<List<StoriesRaw>>> = State.request { moshi.toList(context, R.raw.stories) }
}