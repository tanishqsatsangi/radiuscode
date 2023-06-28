package com.project.radiusagentassignment.coontracts

import android.content.Context
import com.project.radiusagentassignment.models.FacilitiesAPIModel
import retrofit2.Response

interface ListFragmentContract {

    interface  View{
        fun  displayData()

        fun showHideLoader(isShow:Boolean)

        fun showHideList(isShow: Boolean)
    }

    interface  Presenter{

        fun onItemClick()

        fun onLoadData()

    }

    interface Model{
        interface  OnDataFetchedListener{
            fun onDataFetched(response:Response<FacilitiesAPIModel>)
        }

        fun fetchData(context: Context,onDataFetchedListener: OnDataFetchedListener)
        fun getListFromAdapter()

    }
}