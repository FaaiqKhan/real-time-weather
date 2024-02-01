package com.practice.realtimeweather.di

import com.practice.realtimeweather.client.WeatherAPIClient
import com.practice.realtimeweather.interceptor.WeatherAPIInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(WeatherAPIInterceptor("a849de31de4a43c78b2133457242901"))
        .build()

    @Provides
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit = Retrofit
        .Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

    @Provides
    fun provideWeatherAPIClient(retrofit: Retrofit): WeatherAPIClient =
        retrofit.create(WeatherAPIClient::class.java)
}