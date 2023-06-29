package com.project.radiusagentassignment.fields

import com.project.radiusagentassignment.viewholders.BaseViewHolder

abstract class BaseField {
    var name: String? = null
    var icon: String? = null
    var id: String? = null
    var fieldType: FieldType? = null
    var baseViewHolder: BaseViewHolder? = null

    abstract fun unApplyExclusion(optionId: String?)
    abstract fun applyExclusion(optionId: String?)
}