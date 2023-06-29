package com.project.radiusagentassignment.workmangers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.project.radiusagentassignment.DatabaseHelper
import com.project.radiusagentassignment.models.FacilitiesAPIModel
import com.project.radiusagentassignment.retrofit.fetchers.FetcherFactory
import com.project.radiusagentassignment.retrofit.fetchers.ResponseListener
import retrofit2.Response

class SyncWorker(
    private val appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        try {
            val fetcher = FetcherFactory<FacilitiesAPIModel>().getFetcher()
            fetcher.fetch(appContext, object : ResponseListener<FacilitiesAPIModel> {
                override fun onResponseFetched(response: Response<FacilitiesAPIModel>) {
                    if (response.errorBody() != null || !response.isSuccessful) {
                        return
                    }
                    // save data to DB
                    val databaseHelper = DatabaseHelper(appContext, null)
                    databaseHelper.saveList(response.body())
                }

            })
            return Result.success()
        } catch (exception: Exception) {

        }
        return Result.failure()
    }


}