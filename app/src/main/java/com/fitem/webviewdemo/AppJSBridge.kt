package com.fitem.webviewdemo

import android.os.Build
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast
import com.genlot.webviewdemo.BuildConfig

/**
 * Created by LeiGuangwu on 2022/12/15.
 */
class AppJSBridge(val webView: WebView) {

    @JavascriptInterface
    fun getVersionCode(): Int {
        return BuildConfig.VERSION_CODE
    }

    @JavascriptInterface
    fun getVersionName(): String {
        return BuildConfig.VERSION_NAME
    }

    @JavascriptInterface
    fun getSystemVersion(): Int {
        return Build.VERSION.SDK_INT
    }

    @JavascriptInterface
    fun isApp(): String {
        return "true"
    }

    @JavascriptInterface
    fun getWebValue() {
        // 获取H5的 isHome值
        webView.post {
            webView.evaluateJavascript("javascript:isHome()") {
                Toast.makeText(webView.context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }
}