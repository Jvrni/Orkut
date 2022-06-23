package com.jvrni.ui.profile.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jvrni.domain.navigation.Router
import com.jvrni.ui.profile.screen.ProfileScreen
import com.jvrni.ui.profile.viewmodel.ProfileViewModel

@ExperimentalPagerApi
@ExperimentalAnimationApi
fun NavGraphBuilder.profileGraph(router: Router<*>) {
    navigation(
        route = ProfileFeature.route,
        startDestination = ProfileScreen.route,
    ) {
        composable(ProfileScreen.route) {
            val viewModel = hiltViewModel<ProfileViewModel>()

            ProfileScreen(
                viewModel,
                onBack = { router.back() },
                onNavigate = { item -> router.navigateTo(item) }
            )
        }
    }
}
