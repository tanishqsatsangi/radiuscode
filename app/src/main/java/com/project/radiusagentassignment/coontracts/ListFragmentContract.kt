package com.project.radiusagentassignment.coontracts

import android.content.Context
import com.project.radiusagentassignment.models.BaseFacilitiesItem
import com.project.radiusagentassignment.models.FacilitiesAPIModel

interface ListFragmentContract {

    interface View {
        fun displayData(baseFacilitiesItem: BaseFacilitiesItem)

        fun showErrorView()

        fun showHideLoader(isShow: Boolean)

        fun showHideList(isShow: Boolean)
    }

    interface Presenter {

        fun onItemClick(id: String?)

        fun onLoadData()

    }

    interface Model {
        interface OnDataFetchedListener {
            fun onDataFetched(response: FacilitiesAPIModel?)
        }

        fun fetchData(context: Context, onDataFetchedListener: OnDataFetchedListener)

    }
}