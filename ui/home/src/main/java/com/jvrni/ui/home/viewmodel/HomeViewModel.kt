package com.jvrni.ui.home.viewmodel

import androidx.lifecycle.viewModelScope
import com.jvrni.core.base.BaseViewModel
import com.jvrni.core.base.ViewState
import com.jvrni.domain.posts.GetPosts
import com.jvrni.domain.posts.models.Posts
import com.jvrni.domain.stories.GetStories
import com.jvrni.domain.stories.models.Stories
import com.jvrni.domain.users.GetUser
import com.jvrni.domain.users.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPosts: GetPosts,
    private val getStories: GetStories,
    private val getUser: GetUser
) : BaseViewModel() {
    private val user = MutableStateFlow<User?>(null)
    private val posts = MutableStateFlow<List<Posts>>(emptyList())
    private val stories = MutableStateFlow<List<Stories>>(emptyList())

    init {
        viewModelScope.launch {
            combine(user, posts, stories) { user, posts, stories ->
                user?.let { HomeState(it, stories, posts) }
            }.collect { value ->
                if (!value?.posts.isNullOrEmpty() && !value?.stories.isNullOrEmpty())
                    _uiState.update { value }
            }
        }
    }

    fun load() {
        getUser.execute(0).result { result -> user.update { result } }
        getPosts.execute().result { result -> posts.update { result } }
        getStories.execute().result { result -> stories.update { result } }
    }
}

data class HomeState(
    val user: User,
    val stories: List<Stories>,
    val posts: List<Posts>
) : ViewState

