package com.project.radiusagentassignment.presenters

import android.content.Context
import com.project.radiusagentassignment.adapters.FacilitiesAdapterFactory
import com.project.radiusagentassignment.coontracts.ListFragmentContract
import com.project.radiusagentassignment.models.BaseFacilitiesItem
import com.project.radiusagentassignment.models.FacilitiesAPIModel

class FacilitiesListPresenter constructor(
    val context: Context,
    private val listFragmentContractView: ListFragmentContract.View,
    val model: ListFragmentContract.Model
) : ListFragmentContract.Presenter, ListFragmentContract.Model.OnDataFetchedListener {
    private var currentSelectedItem: String? = null
    private var baseItem: BaseFacilitiesItem? = null
    override fun onItemClick(id: String?) {
        unapplyPreviousExlusions()
        currentSelectedItem = id
        applyCurrentExclusions()
    }

    private fun applyCurrentExclusions() {
        if (currentSelectedItem.isNullOrEmpty()) {
            return
        }
        val exclusionList: ArrayList<ArrayList<String>>? = baseItem?.exclusionMap
        if (exclusionList.isNullOrEmpty()) {
            return
        }

        for (item: ArrayList<String> in exclusionList) {
            if (item.contains(currentSelectedItem)) {
                applyExclusions(item)
            }
        }
    }

    private fun unapplyPreviousExlusions() {
        if (currentSelectedItem.isNullOrEmpty()) {
            return
        }
        val exclusionList: ArrayList<ArrayList<String>>? = baseItem?.exclusionMap
        if (exclusionList.isNullOrEmpty()) {
            return
        }

        for (item: ArrayList<String> in exclusionList) {
            if (item.contains(currentSelectedItem)) {
                unApplyExclusions(item)
            }
        }
    }

    private fun unApplyExclusions(item: ArrayList<String>) {
        val schemaMap = baseItem?.schemaMap
        if (schemaMap == null || schemaMap.isEmpty()) {
            return
        }
        for (i: String in item) {
            if (schemaMap.containsKey(i)) {
                schemaMap[i]?.unApplyExclusion(i)
            }
        }
    }

    private fun applyExclusions(item: ArrayList<String>) {
        val schemaMap = baseItem?.schemaMap
        if (schemaMap == null || schemaMap.isEmpty()) {
            return
        }
        for (i: String in item) {
            if (i == currentSelectedItem) {
                continue
            }
            if (schemaMap.containsKey(i)) {
                schemaMap[i]?.applyExclusion(i)
            }
        }
    }

    override fun onLoadData() {
        listFragmentContractView.showHideLoader(true)
        model.fetchData(context, this)
    }

    override fun onDataFetched(response: FacilitiesAPIModel?) {
        val adapter = FacilitiesAdapterFactory().getAdapter();
        val baseFacilitiesItem = adapter.getAdaptedList(context, response)
        if (baseFacilitiesItem == null) {
            //show error on UI
            listFragmentContractView.showErrorView()
        }
        baseFacilitiesItem?.let {
            listFragmentContractView.showHideLoader(false)
            listFragmentContractView.showHideList(true)
            listFragmentContractView.displayData(it)
            baseItem = it
        }

    }
}