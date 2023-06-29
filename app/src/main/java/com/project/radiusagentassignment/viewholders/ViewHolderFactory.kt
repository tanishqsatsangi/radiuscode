package com.project.radiusagentassignment.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.project.radiusagentassignment.databinding.LabelLayoutBinding

class ViewHolderFactory {
    fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LabelLayoutBinding.inflate(inflater)
        return FacilitiesViewHolder(binding)
    }
}