package com.project.radiusagentassignment.fields

import com.project.radiusagentassignment.models.Option

class FacilitiesField : BaseField() {
    var optionList: ArrayList<Option> = arrayListOf()
    override fun unApplyExclusion(optionId: String?) {
        optionId?.let { baseViewHolder?.enableOption(it) }
    }

    override fun applyExclusion(optionId: String?) {
        optionId?.let { baseViewHolder?.disableOption(it) }
    }

}