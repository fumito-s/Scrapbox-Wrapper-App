package com.fumito.scrapboxwrapper.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fumito.scrapboxwrapper.ui.theme.ScrapboxWrapperTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun ScrapboxWrapperApp(
    onExitApp: () -> Unit
) {
    ScrapboxWrapperTheme() {
        ProvideWindowInsets {

            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute =
                navBackStackEntry?.destination?.route ?: ScrapboxWrapperDestinations.HOME_ROUTE

            ScrapboxWrapperNavGraph(
                navController = navController,
                modifier = Modifier,
                onExitApp = onExitApp
            )
        }
    }
}
