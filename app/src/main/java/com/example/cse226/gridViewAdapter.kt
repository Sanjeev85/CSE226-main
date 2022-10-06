package com.example.cse226

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class gridViewAdapter(val ctx: Context, val grid_list: ArrayList<gridItem>) : BaseAdapter() {

    override fun getCount(): Int {
        return grid_list.size
    }

    override fun getItem(position: Int): Any {
        return grid_list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(ctx)
        val view: View = layoutInflater.inflate(R.layout.grid_item, null)
        val img_view = view.findViewById<ImageView>(R.id.img_view)
        val text_view = view.findViewById<TextView>(R.id.text_view)

        img_view?.setImageResource(grid_list.get(position).img!!)
        text_view?.text = grid_list.get(position).text!!

        return view

    }
}