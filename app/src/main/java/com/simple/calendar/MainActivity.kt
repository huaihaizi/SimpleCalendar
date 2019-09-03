package com.simple.calendar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.simple.calendar.adapter.RecycleViewAapter

class MainActivity : AppCompatActivity() {

    lateinit var dateAapter: RecycleViewAapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        initRycycleview()
    }

    /**
     * TODO:初始化
     * @acthor weiang
     * 2019-09-02 23:02
     */
    fun initRycycleview() {
        var dateList = ArrayList<String>()
        dateList.add("2018-01-09")
        dateList.add("2018-02-09")
        dateList.add("2018-04-09")
        dateList.add("2018-07-09")
        dateList.add("2018-10-09")
        dateList.add("2018-11-09")
        dateList.add("2018-12-09")
        dateList.add("2019-01-09")
        dateList.add("2019-03-09")
        dateList.add("2019-05-09")
        dateList.add("2019-06-09")
        dateList.add("2019-07-09")
        dateList.add("2019-08-09")
        dateList.add("2019-09-09")
        var recyclerView = findViewById(R.id.recycleview) as RecyclerView
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        dateAapter = RecycleViewAapter(dateList, this)
        dateAapter.setNewData(dateList)
        recyclerView.adapter = dateAapter
        dateAapter.notifyDataSetChanged()
    }


}
