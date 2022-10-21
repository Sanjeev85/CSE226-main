package com.example.cse226

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

open class BatteryReceiverExample : AppCompatActivity() {
    lateinit var batteryReceiver: chargerLevelReceiver
//    lateinit var wifi: TextView
//    lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)
        val level = findViewById<TextView>(R.id.level)
//        wifi = findViewById<TextView>(R.id.level)
//        batteryReceiver = chargerLevelReceiver(level, this)
//        registerReceiver(batteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
//        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
//        wifi.setOnClickListener {
//            if (wifi.text.toString() == "level") {
//                wifi.text = "On"
//            }
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        unregisterReceiver(batteryReceiver)
    }


    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)
        registerReceiver(wifiStateReceiver, intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }

    private val wifiStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.getIntExtra(
                WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN
            )) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    Toast.makeText(context, "Wifi is On", Toast.LENGTH_SHORT).show()
                }
                WifiManager.WIFI_STATE_DISABLED -> {
                    Toast.makeText(context, "Wifi is Off", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}