package com.project.radiusagentassignment.retrofit.fetchers

import android.content.Context
import com.project.radiusagentassignment.models.FacilitiesAPIModel
import com.project.radiusagentassignment.retrofit.DataList
import com.project.radiusagentassignment.retrofit.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataListFetcher : Fetcher<FacilitiesAPIModel> {
    override fun fetch(
        context: Context,
        responseListener: ResponseListener<FacilitiesAPIModel>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val dataListRetrofit = RetrofitHelper.getInstance().create(DataList::class.java)
            val result = dataListRetrofit.getDataFromServer()
            withContext(Dispatchers.Main) {
                responseListener.onResponseFetched(result)
            }
        }
    }
}