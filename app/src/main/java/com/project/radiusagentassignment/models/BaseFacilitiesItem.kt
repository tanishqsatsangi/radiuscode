package com.project.radiusagentassignment.models

import com.project.radiusagentassignment.fields.BaseField

class BaseFacilitiesItem {
    var fieldList: ArrayList<BaseField>? = null
    var exclusionMap: ArrayList<ArrayList<String>>? = null
    var schemaMap: HashMap<String?, BaseField> = hashMapOf()
}