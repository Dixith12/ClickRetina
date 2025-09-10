package com.example.clickretina.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri

fun OpenLink(context: Context, url: String) {
    try {
        val customTabsIntent = CustomTabsIntent.Builder().build()
        customTabsIntent.launchUrl(context, url.toUri())
    } catch (e: Exception) {
        val browserIntent = Intent(Intent.ACTION_VIEW, url.toUri())
        context.startActivity(browserIntent)
    }
}

