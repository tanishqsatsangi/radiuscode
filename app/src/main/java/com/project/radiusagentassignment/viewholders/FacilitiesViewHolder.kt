package com.project.radiusagentassignment.viewholders

import android.content.Context
import com.project.radiusagentassignment.databinding.LabelLayoutBinding
import com.project.radiusagentassignment.fields.BaseField

class LabelViewHolder(private val binding: LabelLayoutBinding) : BaseViewHolder(binding.root) {

    override fun onBind(context: Context, position: Int, baseField: BaseField) {
        binding.labelTv.text = baseField.name
    }

}