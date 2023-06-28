package com.project.radiusagentassignment.retrofit

import com.project.radiusagentassignment.ApiUrls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {


    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(ApiUrls.facilitiesApiUrls)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}