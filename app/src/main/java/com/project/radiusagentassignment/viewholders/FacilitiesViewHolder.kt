package com.project.radiusagentassignment.viewholders

import android.content.Context
import android.view.View
import android.widget.RadioButton
import com.project.radiusagentassignment.databinding.LabelLayoutBinding
import com.project.radiusagentassignment.fields.BaseField
import com.project.radiusagentassignment.fields.FacilitiesField
import com.project.radiusagentassignment.models.Option


class FacilitiesViewHolder(private val binding: LabelLayoutBinding) : BaseViewHolder(binding.root) {

    override fun onBind(context: Context, position: Int, baseField: BaseField?) {
        if (baseField == null) {
            return
        }
        val facilitiesField: FacilitiesField = baseField as FacilitiesField
        binding.labelTv.text = baseField.name
        addOptions(context, facilitiesField.optionList)
    }

    private fun addOptions(context: Context, options: ArrayList<Option>?) {
        if (options.isNullOrEmpty()) {
            return
        }

        options.forEach { option ->
            val optionRadioButton = RadioButton(context)
            optionRadioButton.id = View.generateViewId()
            optionRadioButton.text = option.name
            optionRadioButton.setOnClickListener(View.OnClickListener {

            })
            binding.radioGroup.addView(optionRadioButton)
        }
    }

}