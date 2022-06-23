package com.jvrni.ui.login.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jvrni.domain.navigation.Router
import com.jvrni.ui.login.screen.LoginScreen
import com.jvrni.ui.login.viewmodel.LoginViewModel

@ExperimentalPagerApi
@ExperimentalAnimationApi
fun NavGraphBuilder.loginGraph(router: Router<*>) {
    navigation(
        route = LoginFeature.route,
        startDestination = LoginScreen.route,
    ) {
        composable(LoginScreen.route) {
            val viewModel = hiltViewModel<LoginViewModel>()

            LoginScreen(
                viewModel,
                onNavigate = { item -> router.navigateTo(item) }
            )
        }
    }
}
