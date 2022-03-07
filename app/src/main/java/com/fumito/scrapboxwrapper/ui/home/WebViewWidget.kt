package com.fumito.scrapboxwrapper.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier

@Composable
fun WebViewWidget() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { WebView(it) },
        update = { webView ->
            webView.webViewClient = WebViewClient()
            webView.apply {
                settings.apply {
                    javaScriptEnabled = true
                    domStorageEnabled = true
                }
            }
            webView.loadUrl("https://scrapbox.io/fumito/")
        }
    )
}
