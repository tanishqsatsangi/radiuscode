package com.project.radiusagentassignment.viewholders

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.RadioButton
import androidx.core.view.marginLeft
import com.project.radiusagentassignment.ItemClickListener
import com.project.radiusagentassignment.R
import com.project.radiusagentassignment.databinding.LabelLayoutBinding
import com.project.radiusagentassignment.fields.BaseField
import com.project.radiusagentassignment.fields.FacilitiesField
import com.project.radiusagentassignment.models.Option


class FacilitiesViewHolder(private val binding: LabelLayoutBinding) : BaseViewHolder(binding.root) {

    override fun onBind(
        context: Context,
        position: Int,
        baseField: BaseField?,
        itemClickListener: ItemClickListener
    ) {
        if (baseField == null) {
            return
        }
        val facilitiesField: FacilitiesField = baseField as FacilitiesField
        binding.labelTv.text = baseField.name
        addOptions(context, facilitiesField.optionList, itemClickListener)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun addOptions(
        context: Context,
        options: ArrayList<Option>?,
        itemClickListener: ItemClickListener
    ) {
        if (options.isNullOrEmpty()) {
            return
        }

        options.forEach { option ->
            val optionRadioButton = RadioButton(context)
            optionRadioButton.id = View.generateViewId()
            optionRadioButton.tag = option.id
            optionRadioButton.text = option.name
            val idImage = option.icon?.let { getImageDrawable(it) }
            val img: Drawable = context.resources.getDrawable(idImage!!)
            img.setBounds(0, 0, 60, 60)
            optionRadioButton.setCompoundDrawables(img, null, null, null)

            optionRadioButton.setOnClickListener {
                itemClickListener.onItemClicked(option.id)
            }
            binding.radioGroup.addView(optionRadioButton)
        }
    }


    override fun disableOption(id: String) {
        val radioButton = binding.radioGroup.findViewWithTag<RadioButton>(id)
        radioButton.isEnabled = false
        radioButton.isClickable = false
        radioButton.invalidate()
    }

    override fun enableOption(id: String) {
        val radioButton = binding.radioGroup.findViewWithTag<RadioButton>(id)
        radioButton.isEnabled = true
        radioButton.isClickable = true
        radioButton.invalidate()
    }

    private fun getImageDrawable(iconId: String): Int {
        return when (iconId) {
            "apartment" -> {
                R.drawable.apartment
            }
            "boat" -> {
                R.drawable.boat
            }
            "condo" -> {
                R.drawable.condo

            }
            "garage" -> {
                R.drawable.garage
            }
            "garden" -> {
                R.drawable.garden

            }
            "land" -> {
                R.drawable.land
            }
            "no-room" -> {
                R.drawable.no_room
            }
            "rooms" -> {
                R.drawable.rooms

            }
            "swimming" -> {
                R.drawable.swimming
            }
            else -> {
                -1
            }
        }

    }
}