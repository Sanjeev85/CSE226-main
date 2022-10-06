package com.example.cse226

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes

class arrayAdapter(
    var mCtx: Context,
    @LayoutRes private val layoutResource: Int,
    var grid_list: ArrayList<gridItem>
) :
    ArrayAdapter<gridItem>(mCtx, layoutResource, grid_list) {
    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getCount(): Int {
        return super.getCount()
    }

    override fun getItem(position: Int): gridItem? {
        return super.getItem(position)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.e("Hello", "Inside getView arrayAdapter")
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResource, null)
        val img = view?.findViewById<ImageView>(R.id.img_view)
        val text_view = view?.findViewById<TextView>(R.id.text_view)

        val item = grid_list.get(position)

        img?.setImageResource(item.img!!)
        text_view?.text = item.text!!

        return view
    }
}