package com.jvrni.orkut.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.jvrni.core.navigation.AppRoutes
import com.jvrni.domain.navigation.Router

class RouterImpl(
    navController: NavHostController
) : Router<NavHostController> {

    override val navigationController = navController

    override fun navigateTo(routes: AppRoutes, resetStack: Boolean) {
        navigationController.navigate(routes.route) {
            if (resetStack) popUpTo(0) // reset stack
            else {
                popUpTo(navigationController.graph.findStartDestination().id) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    override fun back() { navigationController.popBackStack() }

    override fun navigationUp(): Boolean { return navigationController.navigateUp() }
}