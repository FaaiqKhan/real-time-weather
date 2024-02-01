package com.practice.realtimeweather.di

import com.practice.realtimeweather.client.*
import com.practice.realtimeweather.repository.WeatherDataRepository
import com.practice.realtimeweather.repository.WeatherDataRepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
fun interface RealTimeWeatherModule {

    @Binds
    fun bindWeatherClientImplementation(apiClient: WeatherClientImplementation): WeatherClient

}

@Module
@InstallIn(ViewModelComponent::class)
fun interface RealTimeWeatherRepositoryModule {

    @Binds
    fun bindWeatherDataRepositoryImplementation(
        weatherDataRepository: WeatherDataRepositoryImplementation
    ): WeatherDataRepository
}