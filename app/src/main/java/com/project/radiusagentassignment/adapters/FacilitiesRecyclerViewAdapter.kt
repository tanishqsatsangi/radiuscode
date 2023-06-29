package com.project.radiusagentassignment.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.radiusagentassignment.models.BaseFacilitiesItem
import com.project.radiusagentassignment.viewholders.BaseViewHolder
import com.project.radiusagentassignment.viewholders.ViewHolderFactory

class FacilitiesRecyclerViewAdapter(
    private val context: Context,
    private val baseFacilitiesItem: BaseFacilitiesItem
) :
    RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ViewHolderFactory().getViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(context, position,baseFacilitiesItem.fieldList?.get(position))
    }

    override fun getItemCount(): Int {
        return baseFacilitiesItem.fieldList?.size ?: 0
    }
}