package com.jvrni.service

import android.content.Context
import androidx.annotation.RawRes
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

inline fun <reified T> Moshi.toObject(
    context: Context,
    @RawRes file: Int
): T? {
    val json = context.resources.openRawResource(file).bufferedReader().use { it.readText() }
    val adapter: JsonAdapter<T> = adapter(T::class.java)
    return adapter.fromJson(json)
}

inline fun <reified T> Moshi.toList(
    context: Context,
    @RawRes file: Int
): List<T> {
    val json = context.resources.openRawResource(file).bufferedReader().use { it.readText() }
    val adapter: JsonAdapter<List<T>> =
        adapter(Types.newParameterizedType(List::class.java, T::class.java))
    return adapter.fromJson(json) ?: emptyList()
}
