package com.project.radiusagentassignment.repositories

import android.content.Context
import com.project.radiusagentassignment.coontracts.ListFragmentContract
import com.project.radiusagentassignment.models.FacilitiesAPIModel
import com.project.radiusagentassignment.retrofit.fetchers.Fetcher
import com.project.radiusagentassignment.retrofit.fetchers.FetcherFactory
import com.project.radiusagentassignment.retrofit.fetchers.ResponseListener
import retrofit2.Response

class FacilitiesListRepository() : ListFragmentContract.Model,
    ResponseListener<FacilitiesAPIModel> {
    private var dataFetchedListener: ListFragmentContract.Model.OnDataFetchedListener? = null
    override fun fetchData(
        context: Context,
        onDataFetchedListener: ListFragmentContract.Model.OnDataFetchedListener
    ) {
        dataFetchedListener = onDataFetchedListener
        // fethc ressult from DB if not then fetch from API
        val fetcher: Fetcher<FacilitiesAPIModel> = FetcherFactory<FacilitiesAPIModel>().getFetcher()
        fetcher.fetch(context, this)
    }

    override fun getListFromAdapter() {

    }

    override fun onResponseFetched(response: Response<FacilitiesAPIModel>) {
        saveFetchedResposneToDB()
        dataFetchedListener?.onDataFetched(response)
    }

    private fun saveFetchedResposneToDB() {
        // to save response to db
    }
}