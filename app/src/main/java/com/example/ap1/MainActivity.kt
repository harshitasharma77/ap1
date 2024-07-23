package com.example.ap1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize UI elements
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val result = findViewById<TextView>(R.id.result)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divideButton)

        // Set onClickListeners for buttons
        addButton.setOnClickListener {
            val num1 = number1.text.toString().toDouble()
            val num2 = number2.text.toString().toDouble()
            result.text = performOperation(num1, num2, "add").toString()
        }

        subtractButton.setOnClickListener {
            val num1 = number1.text.toString().toDouble()
            val num2 = number2.text.toString().toDouble()
            result.text = performOperation(num1, num2, "subtract").toString()
        }

        multiplyButton.setOnClickListener {
            val num1 = number1.text.toString().toDouble()
            val num2 = number2.text.toString().toDouble()
            result.text = performOperation(num1, num2, "multiply").toString()
        }

        divideButton.setOnClickListener {
            val num1 = number1.text.toString().toDouble()
            val num2 = number2.text.toString().toDouble()
            result.text = performOperation(num1, num2, "divide").toString()
        }
    }

    // Function to perform the required operation
    private fun performOperation(num1: Double, num2: Double, operation: String): Double {
        return when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> if (num2 != 0.0) num1 / num2 else Double.NaN
            else -> Double.NaN
        }
    }
}
