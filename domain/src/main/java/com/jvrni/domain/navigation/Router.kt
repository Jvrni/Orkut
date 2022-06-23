package com.jvrni.domain.navigation

import com.jvrni.core.navigation.AppRoutes


interface Router<T> {
    val navigationController: T
    fun navigateTo(routes: AppRoutes, resetStack: Boolean = false)
    fun back()
    fun navigationUp(): Boolean
}
