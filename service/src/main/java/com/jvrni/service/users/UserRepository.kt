package com.jvrni.service.users

import android.content.Context
import com.jvrni.core.State
import com.jvrni.service.R
import com.jvrni.service.toList
import com.jvrni.service.users.models.UserRaw
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val context: Context,
    private val moshi: Moshi
) {
    fun get(id: Int): Flow<State<UserRaw>> = State.request { moshi.toList<UserRaw>(context, R.raw.users).first { it.id == id } }
}