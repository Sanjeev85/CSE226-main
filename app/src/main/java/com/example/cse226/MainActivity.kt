package com.example.cse226

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var custom_grid_view: GridView
    lateinit var items_list: ArrayList<gridItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        custom_grid_view = findViewById(R.id.grid_view)
        items_list = ArrayList()

        items_list.add(gridItem(R.drawable.fb, "Facebook"))
        items_list.add(gridItem(R.drawable.skype, "Skype"))
        items_list.add(gridItem(R.drawable.twitter, "Twitter"))
        items_list.add(gridItem(R.drawable.youtube, "Youtube"))


        val custom_adapter = arrayAdapter(this@MainActivity, R.layout.grid_item, items_list)

        custom_grid_view?.adapter = custom_adapter

        custom_grid_view.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                // inside on click method we are simply displaying
                // a toast message with course name.
                Toast.makeText(
                    applicationContext, items_list[position].text + " selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

    }
}