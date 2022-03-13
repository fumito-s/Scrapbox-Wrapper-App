package com.fumito.scrapboxwrapper.ui.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun WebViewWidget() {
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
            Log.d("@@@@@@@ updated/ back pressed value", "${backPressed.value}")

            if (backPressed.value) {
                backPressed.value = false
                if (webView.canGoBack()) {
                    Log.d("@@@@@@@ goBack", "")
                    webView.goBack()
                } else {
                    // close app
                    Log.d("@@@@@@@ close app", "")
                }
            }
        }
    )

    BackHandler(
        enabled = true,
        onBack = { backPressed.value = true }
    )
}
