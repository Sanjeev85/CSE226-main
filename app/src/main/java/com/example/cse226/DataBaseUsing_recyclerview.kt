package com.example.cse226

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_data_base_using_recyclerview.*
import kotlinx.android.synthetic.main.activity_database_example.*
import kotlinx.android.synthetic.main.activity_database_example.Age
import kotlinx.android.synthetic.main.activity_database_example.Name
import kotlinx.android.synthetic.main.activity_database_example.addName
import kotlinx.android.synthetic.main.activity_database_example.delete
import kotlinx.android.synthetic.main.activity_database_example.enterAge
import kotlinx.android.synthetic.main.activity_database_example.enterName
import kotlinx.android.synthetic.main.activity_database_example.lv
import kotlinx.android.synthetic.main.activity_database_example.printName
import kotlinx.android.synthetic.main.custom_alert_dialog.*

class DataBaseUsing_recyclerview : AppCompatActivity(), clickEvent {
    lateinit var list: ArrayList<Contact>

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_base_using_recyclerview)
        list = ArrayList<Contact>()
        addName.setOnClickListener {
            val db = DBHelper(this, null)
            val name = enterName.text.toString()
            val age = enterAge.text.toString()
            db.addName(name, age)
            Toast.makeText(this, name + " added to database", Toast.LENGTH_LONG).show()
            enterName.text.clear()
            enterAge.text.clear()
        }

        printName.setOnClickListener {
            val db = DBHelper(this, null)
            val cursor = db.getName()
            Name.text = "Name\n\n"
            Age.text = "Age\n\n"
            list.clear()

            while (cursor!!.moveToNext()) {
                list.add(
                    Contact(
                        cursor.getString(cursor.getColumnIndex(DBHelper.NAME_COl)),
                        cursor.getString(cursor.getColumnIndex(DBHelper.AGE_COL))
                    )
                )
            }

            // at last we close our cursor
            cursor.close()
            recyler.layoutManager = LinearLayoutManager(this)
            recyler.adapter = SqlAdapter(this, list, this)
        }
        delete.setOnClickListener {
            val db = DBHelper(this, null)
            db.delAll()
        }
//

//        lv.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, p, _ ->
//            Log.e(this.toString(), list[p].Age.toString())
//            val dialog = Dialog(this)
//            dialog.setContentView(R.layout.custom_alert_dialog)
//            dialog.show()
//            val prev_name = list[p].Name
//            dialog.update.setOnClickListener {
//                val name = dialog.nameUpdate.text.toString()
//                val age = dialog.ageUpdate.text.toString()
//                Log.e(this.toString(), name + age)
//                val db = DBHelper(this, null)
//                db.updateInDataBase(name, age, prev_name)
//                list[p].Name = name
//                list[p].Age = age
//                dialog.dismiss()
//            }
//            true
//        }
    }

    override fun clickHuaToKarDo(position: Int) {
        Toast.makeText(
            this@DataBaseUsing_recyclerview,
            list[position].Age.toString(),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun longClickHuaToKarDo(position: Int) {
        Toast.makeText(
            this@DataBaseUsing_recyclerview,
            list[position].Age + "Long Click",
            Toast.LENGTH_SHORT
        ).show()
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_alert_dialog)
        dialog.show()
        val prev_name = list[position].Name
        dialog.update.setOnClickListener {
            val name = dialog.nameUpdate.text.toString()
            val age = dialog.ageUpdate.text.toString()
            Log.e(this.toString(), name + age)
            val db = DBHelper(this, null)
            db.updateInDataBase(name, age, prev_name)
            list[position].Name = name
            list[position].Age = age
            dialog.dismiss()
        }


    }
}



