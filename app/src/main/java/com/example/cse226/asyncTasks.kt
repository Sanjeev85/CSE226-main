package com.example.cse226

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import java.nio.channels.AsynchronousByteChannel

class asyncTasks : AppCompatActivity() {

    lateinit var pb: ProgressBar
    lateinit var lv: ListView
    var array = arrayOf("1", "2", "3", "4", "5", "6", "7")
    lateinit var al: ArrayList<String?>
    lateinit var ad: ArrayAdapter<String?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_tasks)

        pb = findViewById(R.id.pb)
        lv = findViewById(R.id.lv)
        al = ArrayList()

        ad = ArrayAdapter(this, android.R.layout.simple_list_item_1, al)
        lv.adapter = ad
        myTask().execute()
    }

//    1st param -> type of input variables value you want to set to the background process, this can be array of object
//    2nd param -> type of objects you are going to enter in the onProgessUpdate method
//    3rd param -> type of the result from the operations you have done in the background process

    internal inner class myTask : AsyncTask<Void?, Int?, String>() {
        var count = 0
        override fun onPreExecute() {
            super.onPreExecute()
            pb.max = 7
            pb.progress = 0
            pb.visibility = View.VISIBLE
            count = 0
        }

        override fun doInBackground(vararg p0: Void?): String {
            for (i in 1..7) {
                count++
                publishProgress(i)
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            return "Completed"
        }

        override fun onProgressUpdate(vararg values: Int?) {
//            super.onProgressUpdate(*values)
            pb.progress = values[0]!!
            al.add(array[count - 1])
            ad.notifyDataSetChanged()

        }

        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
            Toast.makeText(this@asyncTasks, result, Toast.LENGTH_SHORT).show()
            pb.visibility = View.INVISIBLE
        }
    }
}