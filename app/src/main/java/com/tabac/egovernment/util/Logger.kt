package com.tabac.egovernment.util

import timber.log.Timber

fun logd(value: String) {
    Timber.d(value)
}

fun logv(value: String) {
    Timber.v(value)
}

object LoggerConstants {
    const val NETWORK_LOG = "NETWORK_LOG"
}