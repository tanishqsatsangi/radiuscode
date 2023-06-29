package com.project.radiusagentassignment.adapters

import android.content.Context
import com.project.radiusagentassignment.fields.BaseField
import com.project.radiusagentassignment.fields.FacilitiesField
import com.project.radiusagentassignment.fields.FieldType
import com.project.radiusagentassignment.models.BaseFacilitiesItem
import com.project.radiusagentassignment.models.Exclusion
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
        val exclusionMap = getExclusionMap(facilitiesAPIModel.exclusions)
        val baseFacilitiesItem = BaseFacilitiesItem()
        baseFacilitiesItem.exclusionMap = exclusionMap
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
                val id = facilities.facility_id + "_" + option.id
                option.id = id
                optionList.add(option)
            }
            labelField.optionList = optionList
        }
        baseFacilitiesItem.fieldList = fieldList
        baseFacilitiesItem.schemaMap = getSchemaMap(fieldList)
        return baseFacilitiesItem
    }

    private fun getExclusionMap(exclusions: ArrayList<ArrayList<Exclusion>>?): ArrayList<ArrayList<String>>? {
        val exclusionList: ArrayList<ArrayList<String>> = arrayListOf()
        if (exclusions.isNullOrEmpty()) {
            return null
        }

        for (exclusion in exclusions) {
            val singleList: ArrayList<String> = arrayListOf()
            for (i: Exclusion in exclusion) {
                singleList.add(i.facility_id + "_" + i.options_id)
            }
            exclusionList.add(singleList)
        }
        return exclusionList
    }


    private fun getSchemaMap(fieldList: ArrayList<BaseField>): HashMap<String?, BaseField> {
        val hashmap: HashMap<String?, BaseField> = hashMapOf()
        for (field: BaseField in fieldList) {
            val facilitiesField = field as FacilitiesField
            for (option: Option in facilitiesField.optionList) {
                hashmap[option.id] = field
            }
        }
        return hashmap
    }

}