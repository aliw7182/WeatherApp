package kz.aliw7182.weatherapp

import io.reactivex.Observable
import io.reactivex.Single
import kz.aliw7182.weatherapp.models.main
import kz.aliw7182.weatherapp.models.weather
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApiService {


    companion object{
     fun create():WeatherApiService{
         val retrofit = Retrofit.Builder()
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .addConverterFactory(GsonConverterFactory.create())
             .baseUrl("https://api.openweathermap.org/")
             .build()
         return retrofit.create(WeatherApiService::class.java)
     }



 }
    @GET("data/2.5/find")
    fun getWeatherByCity(
        @Query("q") city:String,
        @Query("units") unit:String,
        @Query("appid") key:String
    ):Single<main>



}