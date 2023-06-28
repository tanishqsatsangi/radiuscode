package com.project.radiusagentassignment.retrofit.fetchers

import android.content.Context
import retrofit2.Retrofit

interface Fetcher<T> {
    fun fetch(context: Context, responseListener: ResponseListener<T>)
}