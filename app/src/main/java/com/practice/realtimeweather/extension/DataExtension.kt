package com.practice.realtimeweather.extension

import com.practice.realtimeweather.model.*
import com.practice.realtimeweather.model.network.TodayWeather
import com.practice.realtimeweather.model.network.WeeklyWeather
import com.practice.realtimeweather.model.ui.*
import com.practice.realtimeweather.utils.Utils
import java.time.format.DateTimeFormatter


/**
 * An extension function of TodayWeather data class that provides the successful state on
 * network call success.
 * @see TodayWeather
 *
 * @return TodayWeatherDataResult it provides the data as state.
 * @see TodayWeatherDataResult
 */
fun TodayWeather.toTodayWeatherDataResult(): TodayWeatherDataResult = TodayWeatherDataResult
    .Success(todayWeatherUIData = this.toTodayWeatherUIData())

/**
 * An extension function of TodayWeather data class to parse data.
 * @see TodayWeather
 *
 * Data received from client and parse into UI state to prevent the data modification in view.
 *
 * details - is a map so, we can take advantage of composable of being dynamic.
 * rainDetails - is a map so, we can take advantage of composable of being dynamic.
 * windDetails - is a map so, we can take advantage of composable of being dynamic.
 *
 * @return TodayWeatherUIData which has attributes that are required by the UI.
 * @see TodayWeatherUIData
 */
fun TodayWeather.toTodayWeatherUIData(): TodayWeatherUIData {
    val formatter = DateTimeFormatter.ofPattern("d MMMM, hh:mm")
    return TodayWeatherUIData(
        currentWeather = CurrentWeather(
            date = Utils.getDateTimeFromEpoch(this.current.lastUpdatedEpoch).format(formatter),
            temperature = this.current.tempCelsius.toString(),
            weatherCondition = WeatherCondition(
                weather = this.current.condition.text,
                image = this.current.condition.icon
            ),
            feelsLike = this.current.feelsLikeCelsius.toString(),
            windSpeed = this.current.windKph.toString(),
            details = mapOf(
                "Humidity" to "${this.current.humidity}%",
                "Visibility" to "${this.current.visibilityKm} Km",
                "UVIndex" to this.current.uVIndex.toString(),
            ),
            rainDetails = mapOf(
                "Volume" to "${this.current.precipitationMm} mm",
            ),
            windDetails = mapOf(
                "Wind Guest" to "${this.current.windKph} Km/h",
                "Wind Direction" to this.current.windDirection
            )
        )
    )
}

/**
 * An extension function of WeeklyWeather data class that provides the successful state on
 * network call success.
 * @see WeeklyWeather
 *
 * @return WeeklyWeatherDataResult it provides the data as state.
 * @see WeeklyWeatherDataResult
 */
fun WeeklyWeather.toWeeklyWeatherDataResult(): WeeklyWeatherDataResult =
    WeeklyWeatherDataResult.Success(weeklyWeatherUIData = this.toWeeklyWeatherUIData())

/**
 * An extension function of WeeklyWeather data class to parse data.
 * @see WeeklyWeather
 *
 * Data received from client and parse into UI state to prevent the data modification in view.
 * This function provide WeeklyWeatherUIData in reverse order to show list in ascending order.
 *
 * details - is a map so, we can take advantage of composable of being dynamic.
 *
 * @return WeeklyWeatherUIData which has attributes that are required by the UI.
 * @see WeeklyWeather
 */
fun WeeklyWeather.toWeeklyWeatherUIData(): WeeklyWeatherUIData {
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMM")
    val timeFormatter = DateTimeFormatter.ofPattern("hh:mm")
    return WeeklyWeatherUIData(
        forecast = this.forecast.forecastday.map { forecast ->
            val date = Utils.getDateTimeFromEpoch(forecast.dateEpoch)
            WeatherUIData(
                date = if (Utils.isToday(date)) "Today" else date.format(formatter),
                weatherCondition = WeatherCondition(
                    weather = forecast.day.condition.text,
                    image = forecast.day.condition.icon
                ),
                highTemperature = forecast.day.maxTemperatureInCelsius.toString(),
                lowTemperature = forecast.day.minTemperatureInCelsius.toString(),
                details = mapOf(
                    "Wind" to "${forecast.day.maxWindKph} km/h",
                    "Humidity" to "${forecast.day.avgHumidity}%",
                    "UV Index" to forecast.day.uvIndex.toString(),
                    "Sunrise/Sunset" to "${forecast.astro.sunrise}/${forecast.astro.sunset}"
                ),
                hourlyWeather = forecast.hour.map {
                    HourUIData(
                        temperature = it.temperatureInCelsius.toString(),
                        weatherCondition = WeatherCondition(
                            weather = it.condition.text,
                            image = it.condition.icon
                        ),
                        time = Utils.getDateTimeFromEpoch(it.timeEpoch).format(timeFormatter)
                    )
                }
            )
        }.reversed()
    )
}