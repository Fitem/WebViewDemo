package com.fitem.webviewdemo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.genlot.webviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val webView = binding.webView
        // 启用javascript
        webView.settings.javaScriptEnabled = true
        webView.settings.useWideViewPort = true
        /* 方法二：通过注入JavascriptInterface */
        webView.addJavascriptInterface(AppJSBridge(webView), "appJsBridge")

        /* 加载url */
        webView.loadUrl("file:///android_asset/index.html")

        /* 方法一：直接加载javascript */
//        // 在WebView中注册JavaScript函数
//        webView.loadUrl("javascript:function myFunction() { console.log('hello world!') }")
//        // 在原生代码中调用JavaScript函数
//        webView.loadUrl("javascript:myFunction()")
    }
}