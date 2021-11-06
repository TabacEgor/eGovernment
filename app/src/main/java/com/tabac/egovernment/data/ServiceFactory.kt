package com.tabac.egovernment.data

import com.google.gson.GsonBuilder
import com.tabac.egovernment.BuildConfig
import com.tabac.egovernment.Constants
import com.tabac.egovernment.Constants.CONNECT_TIMEOUT
import com.tabac.egovernment.Constants.READ_TIMEOUT
import com.tabac.egovernment.data.local.ISession
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private fun makeClient(session: ISession): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(HeadersInterceptor(session.token ?: ""))
        .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        .also {
            if (BuildConfig.DEBUG) {
                it.addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
        }
        .build()
}

internal val gson by lazy {
    GsonBuilder()
        .setPrettyPrinting()
//         TODO Implement adapter for date and time
//        .registerTypeAdapter(LocalTime::class.java, LocalTimeConverter())
//        .registerTypeAdapter(LocalDate::class.java, LocalDateConverter())
//        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeConverter())
//        .excludeFieldsWithModifiers(Modifier.TRANSIENT, Modifier.ABSTRACT)
        .create()
}

fun <T> retrofitService(clazz: Class<T>, session: ISession): Lazy<T> = lazy { makeService(clazz, session) }

private fun <T> makeService(clazz: Class<T>, session: ISession): T {
    return Retrofit.Builder()
        .client(makeClient(session))
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(Constants.BASE_URL)
        .build()
        .create(clazz)
}