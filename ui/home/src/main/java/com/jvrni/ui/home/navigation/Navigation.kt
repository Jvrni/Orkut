package com.jvrni.ui.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jvrni.domain.navigation.Router
import com.jvrni.ui.home.screen.HomeScreen
import com.jvrni.ui.home.viewmodel.HomeViewModel

@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
fun NavGraphBuilder.homeGraph(router: Router<*>) {
    navigation(
        route = HomeFeature.route,
        startDestination = HomeScreen.route,
    ) {
        composable(HomeScreen.route) {
            val viewModel = hiltViewModel<HomeViewModel>()

            HomeScreen(
                viewModel,
                onNavigate = { item -> router.navigateTo(item) }
            )
        }
    }
}
