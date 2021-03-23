package com.example.school_cafeteria


import com.example.school_cafeteria.network.Cafeteria_model
import retrofit2.Call

import retrofit2.http.*

interface RetrofitService {
    @GET("/hub/mealServiceDietInfo?ATPT_OFCDC_SC_CODE=F10&SD_SCHUL_CODE=7380292&KEY=f50a392c9e2647e4a030ca8f95d7c568&MLSV_YMD=&Type=json&MMEAL_SC_CODE=1&MMEAL_SC_CODE=2&MMEAL_SC_CODE=3")
    fun getInfo(
            //  인증키
            @Query("KEY") KEY: String,
            //호출 문서(xml, json)
            @Query("Type") Type: String,
            //시도교육청코드
            @Query("ATPT_OFCDC_SC_CODE") ATPT_OFCDC_SC_CODE: String,
            //표준학교코드
            @Query("SD_SCHUL_CODE") SD_SCHUL_CODE: String,
            //식사코드
            @Query("MMEAL_SC_CODE") MMEAL_SC_CODE: String,
            //급식일자
            @Query( "MLSV_YMD") MLSV_YMD: String,

    ) : Call<Cafeteria_model>
}