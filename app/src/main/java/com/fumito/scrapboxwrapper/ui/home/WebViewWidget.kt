package com.fumito.scrapboxwrapper.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView
import android.webkit.WebViewClient

@Composable
fun WebViewWidget() {
    AndroidView(
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
