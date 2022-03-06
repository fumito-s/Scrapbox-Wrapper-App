package com.fumito.scrapboxwrapper.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

/**
 * Destinations used in the [ScrapboxWrapperApp].
 */
object ScrapboxWrapperDestinations {
    const val HOME_ROUTE = "home"
}

class ScrapboxWrapperNavigation(navController: NavController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(ScrapboxWrapperDestinations.HOME_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
