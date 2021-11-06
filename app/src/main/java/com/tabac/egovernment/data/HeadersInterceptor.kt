package com.tabac.egovernment.data

import com.tabac.egovernment.util.LoggerConstants.NETWORK_LOG
import com.tabac.egovernment.util.logd
import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor(private val token: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        logd("$NETWORK_LOG Not yet implemented")
        return chain.proceed(chain.request())
    }
}