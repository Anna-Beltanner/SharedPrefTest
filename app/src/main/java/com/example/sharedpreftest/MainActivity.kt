package com.example.sharedpreftest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        bt_button.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {

        val insertedText: String = edit_text.text.toString()
        tv_text.text = insertedText

        val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.apply {
            putString("STRING_KEY", insertedText)
            putBoolean("BOOLEAN_KEY", sw_switch.isChecked)
        }.apply()

        Toast.makeText(this, "Data is saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadData(){
        val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString: String? = sharedPreferences.getString("STRING_KEY", null)
        val savedBoolean: Boolean = sharedPreferences.getBoolean("BOOLEAN_KEY", false)

        tv_text.text = savedString
        sw_switch.isChecked = savedBoolean

    }
}