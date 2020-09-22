package kz.aliw7182.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kz.aliw7182.weatherapp.models.weather

class MainActivity : AppCompatActivity() {
    private val weatherApiService = WeatherApiService.create()
    private val disposable = CompositeDisposable()
    private val key = "ca303a6bb68c639b1a72229e9b920286"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        show_btn.setOnClickListener {
            getData()

        }
    }
private fun getData(){
    weatherApiService.getWeatherByCity(city_input.text.toString(),"metric",key)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
                result_view.text =it.toString()
            },
            {
                Log.e("ERROR",it.message.toString())
            }
        ).also { disposable }
}

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }



    }



