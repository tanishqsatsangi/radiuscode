package com.project.radiusagentassignment.viewholders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.project.radiusagentassignment.ItemClickListener
import com.project.radiusagentassignment.fields.BaseField

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun onBind(
        context: Context,
        position: Int,
        baseField: BaseField?,
        itemClickListener: ItemClickListener
    )

    abstract fun disableOption(id: String)
    abstract fun enableOption(id: String)
}