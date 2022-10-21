package com.example.cse226

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var customListView: ListView
    lateinit var items_list: ArrayList<listItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        customListView = findViewById(R.id.grid_view)
        items_list = ArrayList()

        items_list.add(listItem(R.drawable.fb, "Facebook", "Facebook"))
        items_list.add(listItem(R.drawable.fb, "Facebook", "Facebook"))
        items_list.add(listItem(R.drawable.fb, "Facebook", "Facebook"))
        items_list.add(listItem(R.drawable.fb, "Facebook", "Facebook"))


        val custom_adapter = arrayAdapter(this@MainActivity, R.layout.custom_recycle_list, items_list)

        customListView?.adapter = custom_adapter

        customListView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                // inside on click method we are simply displaying
                // a toast message with course name.
                Toast.makeText(
                    applicationContext, items_list[position].version + " selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

    }
}