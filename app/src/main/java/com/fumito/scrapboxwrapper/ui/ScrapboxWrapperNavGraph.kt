package com.fumito.scrapboxwrapper.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fumito.scrapboxwrapper.ui.home.WebViewWidget

@Composable
fun ScrapboxWrapperNavGraph(
    modifier: Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ScrapboxWrapperDestinations.HOME_ROUTE
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ScrapboxWrapperDestinations.HOME_ROUTE) {
            WebViewWidget()
        }
    }
}
