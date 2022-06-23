package com.jvrni.ui.profile.viewmodel

import androidx.lifecycle.viewModelScope
import com.jvrni.core.base.BaseViewModel
import com.jvrni.core.base.ViewState
import com.jvrni.domain.users.GetUser
import com.jvrni.domain.users.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUser: GetUser
) : BaseViewModel() {

    init {
        viewModelScope.launch {
            getUser.execute(0).result { result -> _uiState.update { ProfileState(result) } }
        }
    }
}

data class ProfileState(val user: User) : ViewState