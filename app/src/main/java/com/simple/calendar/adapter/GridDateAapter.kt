package com.simple.calendar.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.simple.calendar.R
import com.simple.calendar.bean.DateInfo

class GridDateAapter(data: ArrayList<DateInfo>?) : BaseQuickAdapter<DateInfo, BaseViewHolder>(R.layout.item_gradview_layout) {

    override fun convert(helper: BaseViewHolder?, item: DateInfo?) {
        var date: TextView = helper?.getView(R.id.text_content)!!
        date.text = item?.time
        if (helper?.adapterPosition == 11) {
            date.isSelected = true
        } else {
            date.isSelected = false
        }

    }
}

