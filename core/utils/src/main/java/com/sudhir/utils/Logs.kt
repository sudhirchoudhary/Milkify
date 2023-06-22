package com.sudhir.utils

import android.util.Log

fun Any.log(message: String, tag: String, loggingLevel: LoggingLevel) {
    when (loggingLevel) {
        LoggingLevel.Error -> Log.e(tag, message)
        LoggingLevel.Debug -> Log.d(tag, message)
        LoggingLevel.Warn -> Log.w(tag, message)
    }
}

fun Any.logd(message: String, tag: String = "Sudhir") {
    log(message, tag, LoggingLevel.Debug)
}


enum class LoggingLevel {
    Error,
    Debug,
    Warn
}