package com.practice.realtimeweather.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class WeatherAPIInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val authenticatedRequest = chain.request().newBuilder()
            .header("Accept", "application/json")
            .header("Key", apiKey)
            .build()
        return chain.proceed(authenticatedRequest)
    }
}