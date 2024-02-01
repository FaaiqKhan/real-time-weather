package com.practice.realtimeweather.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * This interceptor is used to add apikey in the header before making call to the weather server.
 * @param apiKey WeatherAPI key provided by the Weather website
 */

class WeatherAPIInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val authenticatedRequest = chain.request().newBuilder()
            .header("Accept", "application/json")
            .header("Key", apiKey)
            .build()
        return chain.proceed(authenticatedRequest)
    }
}