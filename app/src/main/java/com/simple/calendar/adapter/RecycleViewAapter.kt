package com.simple.calendar.adapter

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.simple.calendar.R
import com.simple.calendar.bean.DateInfo
import com.simple.calendar.utils.AppUtils

class RecycleViewAapter() : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_recycle_layout) {
    lateinit var data: ArrayList<String>
    lateinit var context: Context

    constructor(data: ArrayList<String>?, context: Context) : this() {
        this@RecycleViewAapter.context = context
        this@RecycleViewAapter.data = data!!
    }

    override fun convert(helper: BaseViewHolder?, item: String?) {
        var text_month: TextView = helper?.getView(R.id.text_month)!!
        var recycleview: RecyclerView = helper?.getView(R.id.recycleview)!!
        var dateList = ArrayList<DateInfo>()
        var map = AppUtils.getMonthAndYearByString(item)
        var year = map.get("year")
        var month = map.get("month")
        var number = AppUtils.getMonthOfDay(year?.toInt()!!, month?.toInt()!!)
        var week = AppUtils.getWeek(year+"-"+month+"-01")
        text_month.text = item
        Log.d("hhh", "---------item----->:$item")
        Log.d("hhh", "---------year---:$year--------month-->:$month")
        Log.d("hhh", "---------week----->:$week")
        /** 1,周天* 2,周一* 3,周二* 4,周三* 5,周四* 6,周五* 7,周六 */
        var nullWeekNum = 0
        if(1==week){
            nullWeekNum = 0
        }else{
            nullWeekNum = week-1
        }
        if(nullWeekNum>0){
            for (i in 1..nullWeekNum){
                var info = DateInfo()
                info.time = ""
                dateList.add(info)
            }
        }
        for (i in 1..number) {
            var info = DateInfo()
            info.time = i.toString()
            dateList.add(info)
        }
        recycleview.setLayoutManager(GridLayoutManager(context, 7))
        var gridDateAapter = GridDateAapter(dateList)
        gridDateAapter.setNewData(dateList)
        recycleview.adapter = gridDateAapter
        gridDateAapter.notifyDataSetChanged()
    }
}

