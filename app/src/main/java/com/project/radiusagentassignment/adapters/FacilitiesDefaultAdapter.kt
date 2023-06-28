package com.project.radiusagentassignment.adapters

import android.content.Context
import com.project.radiusagentassignment.models.BaseFacilitiesItem
import com.project.radiusagentassignment.fields.BaseField
import com.project.radiusagentassignment.fields.FieldType
import com.project.radiusagentassignment.fields.LabelField
import com.project.radiusagentassignment.fields.OptionField
import com.project.radiusagentassignment.models.FacilitiesAPIModel

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
            val labelField = LabelField()
            labelField.id = facilities.facility_id
            labelField.name = facilities.name
            labelField.fieldType = FieldType.LABEL
            fieldList.add(labelField)
            if (facilities.options == null) {
                continue
            }
            for (option in facilities.options!!) {
                val optionField = OptionField()
                optionField.id = option.id
                optionField.name = option.name
                optionField.icon = option.icon
                optionField.fieldType = FieldType.OPTION
                fieldList.add(optionField)
            }
        }
        baseFacilitiesItem.fieldList = fieldList
        return baseFacilitiesItem
    }
}