package com.jvrni.service

import android.content.Context
import com.jvrni.service.posts.PostsRepository
import com.jvrni.service.stories.StoriesRepository
import com.jvrni.service.users.UserRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    fun providesPostsRepository(
        @ApplicationContext context: Context,
        moshi: Moshi
    ) = PostsRepository(context, moshi)

    @Provides
    fun providesUserRepository(
        @ApplicationContext context: Context,
        moshi: Moshi
    ) = UserRepository(context, moshi)

    @Provides
    fun providesStoriesRepository(
        @ApplicationContext context: Context,
        moshi: Moshi
    ) = StoriesRepository(context, moshi)
}