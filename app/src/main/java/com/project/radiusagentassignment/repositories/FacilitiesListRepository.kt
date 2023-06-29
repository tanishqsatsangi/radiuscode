package com.project.radiusagentassignment.repositories

import android.content.Context
import com.project.radiusagentassignment.DatabaseHelper
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
        //fetch result from DB
        val databaseHelper = DatabaseHelper(context, null)
        val apiModel = databaseHelper.getList()
        if (apiModel == null) {
            //no data in DB fetch from API
            dataFetchedListener = onDataFetchedListener
            val fetcher: Fetcher<FacilitiesAPIModel> =
                FetcherFactory<FacilitiesAPIModel>().getFetcher()
            fetcher.fetch(context, this)
        } else {
            //return db result only
            dataFetchedListener?.onDataFetched(apiModel)
        }


    }

    override fun getListFromAdapter() {

    }

    override fun onResponseFetched(response: Response<FacilitiesAPIModel>) {
        saveFetchedResponseToDB()
        dataFetchedListener?.onDataFetched(response.body())
    }

    private fun saveFetchedResponseToDB() {
        // to save response to db
    }
}