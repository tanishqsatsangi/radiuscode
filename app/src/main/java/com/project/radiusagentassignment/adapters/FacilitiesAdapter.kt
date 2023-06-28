package com.project.radiusagentassignment.adapters

import android.content.Context
import com.project.radiusagentassignment.models.BaseFacilitiesItem
import com.project.radiusagentassignment.models.FacilitiesAPIModel

interface FacilitiesAdapter {

    fun getAdaptedList(context: Context,
                       facilitiesAPIModel: FacilitiesAPIModel?
    ):BaseFacilitiesItem?
}