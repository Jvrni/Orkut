package com.jvrni.ui.splash.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable
import com.jvrni.domain.navigation.Router
import com.jvrni.ui.login.navigation.LoginScreen
import com.jvrni.ui.splash.screen.SplashScreen
import com.jvrni.ui.splash.viewmodel.SplashViewModel

@ExperimentalAnimationApi
fun NavGraphBuilder.splashGraph(router: Router<*>) {
    navigation(
        route = SplashFeature.route,
        startDestination = SplashScreen.route,
    ) {
        composable(SplashScreen.route) {
            val viewModel = hiltViewModel<SplashViewModel>()
            SplashScreen(viewModel) {
                router.navigateTo(LoginScreen, true)
            }
        }
    }
}