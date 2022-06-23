package com.jvrni.orkut.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jvrni.ui.home.navigation.homeGraph
import com.jvrni.ui.login.navigation.loginGraph
import com.jvrni.ui.profile.navigation.profileGraph
import com.jvrni.ui.splash.navigation.SplashFeature
import com.jvrni.ui.splash.navigation.splashGraph

@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@Composable
fun Navigator(router: RouterImpl) {
    val mainNav = RouterImpl(rememberAnimatedNavController())

    AnimatedNavHost(
        router.navigationController,
        startDestination = SplashFeature.route
    ) {
        splashGraph(router)
        loginGraph(router)
        homeGraph(router)
        profileGraph(router)
    }
}