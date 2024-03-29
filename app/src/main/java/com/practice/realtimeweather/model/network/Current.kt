package com.practice.realtimeweather.model.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Current(
    @Json(name = "last_updated_epoch")
    val lastUpdatedEpoch: Long,
    @Json(name = "last_updated")
    val lastUpdated: String,
    @Json(name = "temp_c")
    val tempCelsius: Double,
    @Json(name = "temp_f")
    val tempFahrenheit: Double,
    val condition: Condition,
    @Json(name = "wind_mph")
    val windMph: Double,
    @Json(name = "wind_kph")
    val windKph: Double,
    @Json(name = "wind_degree")
    val windDegree: Int,
    @Json(name = "wind_dir")
    val windDirection: String,
    @Json(name = "pressure_mb")
    val pressureMb: Double,
    @Json(name = "pressure_in")
    val pressureIn: Double,
    @Json(name = "precip_mm")
    val precipitationMm: Double,
    @Json(name = "precip_in")
    val precipitationIn: Double,
    val humidity: Double,
    @Json(name = "feelslike_c")
    val feelsLikeCelsius: Double,
    @Json(name = "feelslike_f")
    val feelsLikeFahrenheit: Double,
    @Json(name = "vis_km")
    val visibilityKm: Double,
    @Json(name = "vis_miles")
    val visibilityMiles: Double,
    @Json(name = "uv")
    val uVIndex: Double,
    @Json(name = "gust_mph")
    val gustMph: Double,
    @Json(name = "gust_kph")
    val gustKph: Double,
)
