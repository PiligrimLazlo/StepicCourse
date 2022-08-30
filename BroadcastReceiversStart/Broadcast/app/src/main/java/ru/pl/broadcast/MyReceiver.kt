package ru.pl.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            //action из MyService
            "loaded" -> {
                val percent = intent.getIntExtra("percent", 0)
                Toast.makeText(context, "Percent: $percent%", Toast.LENGTH_SHORT).show()
            }
            //пример своего action
            ACTION_CLICKED -> {
                val clickedCount = intent.getIntExtra(EXTRA_CLICKED_COUNT, 0)
                Toast.makeText(context, "Clicked $clickedCount times", Toast.LENGTH_SHORT).show()
            }

            //action низкой батареи
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context, "Low battery", Toast.LENGTH_SHORT).show()
            }
            //action изменения режима полета
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val turnedOn = intent.getBooleanExtra("state", false)
                Toast.makeText(
                    context, "Airplane mode changed. Turned on: $turnedOn",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        const val ACTION_CLICKED = "ACTION_CLICKED"
        const val EXTRA_CLICKED_COUNT = "EXTRA_CLICKED_COUNT"
    }

}