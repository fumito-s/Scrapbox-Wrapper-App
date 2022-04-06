package com.fumito.scrapboxwrapper.ui.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onExitApp: () -> Unit
) {
    Scaffold(
        floatingActionButton = { ImeFab() }
    ) {
        WebViewWidget(onExitApp)
    }
}
