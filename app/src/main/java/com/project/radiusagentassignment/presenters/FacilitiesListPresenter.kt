package com.project.radiusagentassignment.presenters

import android.content.Context
import com.project.radiusagentassignment.adapters.FacilitiesAdapterFactory
import com.project.radiusagentassignment.coontracts.ListFragmentContract
import com.project.radiusagentassignment.models.FacilitiesAPIModel
import retrofit2.Response

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

    override fun onDataFetched(response: Response<FacilitiesAPIModel>) {
        val adapter = FacilitiesAdapterFactory().getAdapter();
        adapter.getAdaptedList(context, response.body())

    }
}