package kz.aliw7182.weatherapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Weather(
    val list: List<CityWeather>
)

data class CityWeather (
    val id: String,
    val name: String,
    val coord: Coordination,
    val main: Temperature
)

data class Coordination (
    val lat: Double,
    val lon: Double
)
data class Temperature (
    val temp: Int
)
