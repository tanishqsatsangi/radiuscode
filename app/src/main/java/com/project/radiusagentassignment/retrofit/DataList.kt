package com.project.radiusagentassignment.retrofit

import com.project.radiusagentassignment.models.FacilitiesAPIModel
import retrofit2.Response
import retrofit2.http.GET

interface DataList {
    @GET("/iranjith4/ad-assignment/db")
    suspend fun getDataFromServer(): Response<FacilitiesAPIModel>
}