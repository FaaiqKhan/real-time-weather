package com.practice.realtimeweather.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Day(
    @Json(name = "maxtemp_c")
    val maxTemperatureInCelsius: Double,
    @Json(name = "maxtemp_f")
    val maxTemperatureInFahrenheit: Double,
    @Json(name = "mintemp_c")
    val minTemperatureInCelsius: Double,
    @Json(name = "mintemp_f")
    val minTemperatureInFahrenheit: Double,
    @Json(name = "avgtemp_c")
    val avgTemperatureInCelsius: Double,
    @Json(name = "avgtemp_f")
    val avgTemperatureInFahrenheit: Double,
    @Json(name = "maxwind_mph")
    val maxWindMph: Double,
    @Json(name = "maxwind_kph")
    val maxWindKph: Double,
    @Json(name = "totalprecip_mm")
    val totalPrecipitationInMM: Double,
    @Json(name = "totalprecip_in")
    val totalPrecipitationInInch: Double,
    @Json(name = "avgvis_km")
    val avgVisibilityInKm: Double,
    @Json(name = "avgvis_miles")
    val avgVisibilityInMiles: Double,
    @Json(name = "avghumidity")
    val avgHumidity: Int,
    val condition: Condition,
    @Json(name = "uv")
    val uvIndex: Double
)
