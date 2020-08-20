package com.airatlovesmusic.ribs.data

import android.util.Log

class Logger {
    fun logMessage(message: String) {
        Log.d(this.javaClass.simpleName, message)
    }
}