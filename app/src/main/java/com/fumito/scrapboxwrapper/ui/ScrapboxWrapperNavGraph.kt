package com.fumito.scrapboxwrapper.ui

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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
            Text(
                modifier = Modifier.background(color = Color.Cyan),
                color = Color.Black,
                fontSize = 50.sp,
                text = "AAAAAAAAA"
            )
        }
    }
}
