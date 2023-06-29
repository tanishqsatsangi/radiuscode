package com.project.radiusagentassignment.presenters

import android.content.Context
import com.project.radiusagentassignment.adapters.FacilitiesAdapterFactory
import com.project.radiusagentassignment.coontracts.ListFragmentContract
import com.project.radiusagentassignment.models.FacilitiesAPIModel

class FacilitiesListPresenter constructor(
    val context: Context,
    private val listFragmentContractView: ListFragmentContract.View,
    val model: ListFragmentContract.Model
) : ListFragmentContract.Presenter, ListFragmentContract.Model.OnDataFetchedListener {
    override fun onItemClick() {

    }

    override fun onLoadData() {
        listFragmentContractView.showHideLoader(true)
        listFragmentContractView.showHideList(false)
        model.fetchData(context, this)
    }

    override fun onDataFetched(response: FacilitiesAPIModel?) {
        val adapter = FacilitiesAdapterFactory().getAdapter();
        val baseFacilitiesItem = adapter.getAdaptedList(context, response)
        if (baseFacilitiesItem == null) {
            //show error on UI
        }
        baseFacilitiesItem?.let {
            listFragmentContractView.showHideLoader(false)
            listFragmentContractView.displayData(it)

        }

    }
}