package com.project.radiusagentassignment.retrofit.fetchers

import retrofit2.Response

interface ResponseListener<T> {
    fun onResponseFetched(response: Response<T>)
}