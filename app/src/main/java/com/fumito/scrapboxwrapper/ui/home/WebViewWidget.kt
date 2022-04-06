package com.fumito.scrapboxwrapper.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun WebViewWidget(
    onExitApp: () -> Unit
) {
    val backPressed = remember { mutableStateOf(false) }
    AndroidView(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding(),
        factory = {
            WebView(it).apply {
                webViewClient = WebViewClient()
                settings.apply {
                    javaScriptEnabled = true
                    domStorageEnabled = true

                }
            }.also { webView ->
                webView.loadUrl("https://scrapbox.io/fumito/")
            }
        },
        update = { webView ->
            if (backPressed.value) {
                backPressed.value = false
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    // close app
                    onExitApp()
                }
            }
        }
    )

    BackHandler(
        enabled = true,
        onBack = { backPressed.value = true }
    )
}

@Composable
fun ImeFab() {
    FloatingActionButton(onClick = { /*do something*/ }) {
        Icon(Icons.Filled.Edit, contentDescription = "edit")
    }
}
