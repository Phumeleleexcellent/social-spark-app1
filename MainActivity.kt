package com.example.socialspark

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dropdown = findViewById<AutoCompleteTextView>(R.id.dropdownTime)
        val btnSuggest = findViewById<MaterialButton>(R.id.btnSuggest)
        val btnReset = findViewById<MaterialButton>(R.id.btnReset)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        val items = listOf("morning", "afternoon", "evening", "night")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        dropdown.setAdapter(adapter)

        btnSuggest.setOnClickListener {
            val input = dropdown.text.toString().lowercase()

            if (input.isEmpty()) {
                Toast.makeText(this, "Enter time of day", Toast.LENGTH_SHORT).show()
            } else {
                val result = when(input) {
                    "morning" -> "☕ Coffee with a friend"
                    "afternoon" -> "🍔 Lunch or study"
                    "evening" -> "🌆 Dinner or walk"
                    "night" -> "🎬 Movie or chat"
                    else -> "❌ Invalid input"
                }
                txtResult.text = result
            }
        }

        btnReset.setOnClickListener {
            dropdown.text.clear()
            txtResult.text = "Your result will appear here"
        }
    }
}
