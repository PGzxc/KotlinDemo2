package com.example.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClick {

    private var data = ArrayList<String>()
    private var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MyAdapter()
        adapter!!.add(getData())
        val manager = LinearLayoutManager(application)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter

        adapter!!.setItemClick(this)
    }

    fun getData(): List<String> {
        for (i in 1..100) {
            data!!.add("我是标题" + i)
        }
        return data
    }
    override fun onItemClick(view: View, postion: Int) {
        Toast.makeText(applicationContext, "我是第" + postion + "个", Toast.LENGTH_SHORT).show()
    }


}



