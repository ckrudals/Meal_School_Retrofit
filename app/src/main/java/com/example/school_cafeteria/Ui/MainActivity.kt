package com.example.school_cafeteria.Ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.school_cafeteria.R
import com.example.school_cafeteria.RetrofitService
import com.example.school_cafeteria.databinding.MealActivityMainBinding
import com.example.school_cafeteria.network.Cafeteria_model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    lateinit var myAPI: RetrofitService
    private val TAG = "MainActivity"
    private val binding by lazy { MealActivityMainBinding.inflate(layoutInflater) }




    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meal_activity_main)

        val mealPager = binding.mealViewPager

        binding.previousBtn.setOnClickListener {
            Log.d(TAG, "MainActivity - 이전 버튼 클릭")

            mealPager.currentItem = mealPager.currentItem - 1
        }

        binding.nextBtn.setOnClickListener {
            Log.d(TAG, "MainActivity - 다음 버튼 클릭")
            mealPager.currentItem = mealPager.currentItem + 1
        }


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        actionBar?.hide()

        // mealPager 설정



        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ISO_DATE
        val formatted = current.format(formatter)



        retrofit = RetrofitBuilder.getInstance()
        myAPI = retrofit.create(RetrofitService::class.java)

        myAPI.getInfo("f50a392c9e2647e4a030ca8f95d7c568", "json", "F10", "7380292", "1", formatted)
            .enqueue(object : Callback<Cafeteria_model> {
                override fun onFailure(call: Call<Cafeteria_model>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(
                    call: Call<Cafeteria_model>,
                    response: Response<Cafeteria_model>
                ) {
                    var name = response.body()?.result
                    if (!response.isSuccessful) {

                        return
                    }

                    Log.d(TAG, "onResponse: $name")



                }


            })

    }
}


