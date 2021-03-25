package com.example.school_cafeteria.Ui

import android.content.ContentValues
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.school_cafeteria.Model.meal_model
import com.example.school_cafeteria.R
import com.example.school_cafeteria.RetrofitViewModel
import com.example.school_cafeteria.databinding.MealActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val binding by lazy { MealActivityMainBinding.inflate(layoutInflater) }


    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("YYYYMMdd")
    val formatted = current.format(formatter)

    private val retrofitViewModel: RetrofitViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal_activity_main)

        binding.dayText.text = formatted

        Retrofit(1)

        binding.breakBtn.setOnClickListener {
            Log.d(TAG, "onClick: bereak")
            Retrofit(1)
        }

        binding.launchBtn.setOnClickListener {
            Log.d(TAG, "onClick: lanch")
            Retrofit(2)
        }

        binding.dinnerBtn.setOnClickListener {

            Log.d(TAG, "onClick: dinner")
            Retrofit(3)


        }


    }

    fun Retrofit(time: Int) {
        RetrofitBuilder.service.getInfo(MLSV_YMD = formatted, MMEAL_SC_CODE = time).enqueue(object : Callback<meal_model> {
            override fun onFailure(call: Call<meal_model>, t: Throwable) {
                t.printStackTrace()
                Log.d(ContentValues.TAG, "MainActivity - onFailure()")
            }

            override fun onResponse(
                    call: Call<meal_model>,
                    response: Response<meal_model>
            ) {

                if (response.isSuccessful) {
                    val res = response.body()?.mealServiceDietInfo?.get(1)?.row



                    if (res != null) {
                        for (i in res.indices) {
                            val obj = res[i]
                            val row = obj.DDISH_NM
                            Log.d(TAG, "onResponse: $row")
                            when (time) {
                                1 -> {
                                    binding.text.text = row
                                    Log.d(TAG, "onResponse: $binding.text.text")
                                }
                                2 -> {
                                    binding.text.text = row
                                    Log.d(TAG, "onResponse: $binding.text.text")
                                }
                                3 -> {
                                    binding.text.text = row
                                    Log.d(TAG, "onResponse: $binding.text.text")

                                }
                            }

                        }
                    } else {
                        Log.d(ContentValues.TAG, "onResponse: ${response.code()}")
                    }

                }
            }


        })
    }
}





