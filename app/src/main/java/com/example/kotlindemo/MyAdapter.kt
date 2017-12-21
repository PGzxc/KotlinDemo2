package com.example.kotlindemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by admin on 2017/12/21.
 */
class MyAdapter : RecyclerView.Adapter<MyHolder>() {

    var list: List<String> = ArrayList<String>()

    var click: OnItemClick? = null

    fun add(list: List<String>) {
        this.list = list
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder!!.textView.setText(list!!.get(position))
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.item_holder_view, parent, false)
        val holder = MyHolder(view, click!!)
        return holder
    }

    fun setItemClick(click: OnItemClick) {
        this.click = click
    }

}