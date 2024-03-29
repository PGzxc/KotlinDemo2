package com.example.kotlindemo

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.TextView

/**
 * Created by admin on 2017/12/21.
 */
class MyHolder(itemView: View, click: OnItemClick) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var textView: TextView

    private var click: OnItemClick? = null

    init {
        textView = itemView.findViewOften(R.id.textView)
        this.click = click
        itemView.setOnClickListener(this)
    }


    fun <T : View> View.findViewOften(viewId: Int): T {
        var viewHolder: SparseArray<View> = tag as? SparseArray<View> ?: SparseArray()
        tag = viewHolder
        var childView: View? = viewHolder.get(viewId)
        if (null == childView) {
            childView = findViewById(viewId)
            viewHolder.put(viewId, childView)
        }
        return childView as T
    }

    override fun onClick(v: View?) {
        if (v != null) {
            click!!.onItemClick(v, adapterPosition)
        }
    }

}