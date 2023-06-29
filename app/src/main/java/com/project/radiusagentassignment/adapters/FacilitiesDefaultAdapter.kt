package com.project.radiusagentassignment.adapters

import android.content.Context
import com.project.radiusagentassignment.fields.BaseField
import com.project.radiusagentassignment.fields.FacilitiesField
import com.project.radiusagentassignment.fields.FieldType
import com.project.radiusagentassignment.models.BaseFacilitiesItem
import com.project.radiusagentassignment.models.FacilitiesAPIModel
import com.project.radiusagentassignment.models.Option

class FacilitiesDefaultAdapter : FacilitiesAdapter {
    override fun getAdaptedList(
        context: Context,
        facilitiesAPIModel: FacilitiesAPIModel?
    ): BaseFacilitiesItem? {
        if (facilitiesAPIModel?.facilities == null) {
            return null
        }
        val baseFacilitiesItem = BaseFacilitiesItem()
        val fieldList: ArrayList<BaseField> = arrayListOf()
        for (facilities in facilitiesAPIModel.facilities) {
            val labelField = FacilitiesField()
            labelField.id = facilities.facility_id
            labelField.name = facilities.name
            labelField.fieldType = FieldType.FACILITIES
            fieldList.add(labelField)
            if (facilities.options == null) {
                continue
            }
            val optionList: ArrayList<Option> = arrayListOf()
            for (option in facilities.options!!) {
                optionList.add(option)
            }
            labelField.optionList = optionList
        }
        baseFacilitiesItem.fieldList = fieldList
        return baseFacilitiesItem
    }
}