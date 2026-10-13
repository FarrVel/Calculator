package com.example.calculator

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
        setContentView(R.layout.activity_main)

        val etAngka1 = findViewById<EditText>(R.id.etAngka1)
        val etAngka2 = findViewById<EditText>(R.id.etAngka2)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnKurang = findViewById<Button>(R.id.btnKurang)
        val btnKali = findViewById<Button>(R.id.btnKali)
        val btnBagi = findViewById<Button>(R.id.btnBagi)
        val btnClear = findViewById<Button>(R.id.btnClear)

        btnTambah.setOnClickListener {
            hitung(etAngka1, etAngka2, tvResult, "+")
        }

        btnKurang.setOnClickListener {
            hitung(etAngka1, etAngka2, tvResult, "-")
        }

        btnKali.setOnClickListener {
            hitung(etAngka1, etAngka2, tvResult, "*")
        }

        btnBagi.setOnClickListener {
            hitung(etAngka1, etAngka2, tvResult, "/")
        }

        btnClear.setOnClickListener {
            etAngka1.text.clear()
            etAngka2.text.clear()
            tvResult.text = "Result\n0"
        }
    }

    private fun hitung(et1: EditText, et2: EditText, tvRes: TextView, operator: String) {
        val angka1 = et1.text.toString().toDoubleOrNull() ?: 0.0
        val angka2 = et2.text.toString().toDoubleOrNull() ?: 0.0

        val hasil: Double? = when (operator) {
            "+" -> angka1 + angka2
            "-" -> angka1 - angka2
            "*" -> angka1 * angka2
            "/" -> {
                if (angka2 == 0.0) {
                    null
                } else {
                    angka1 / angka2
                }
            }
            else -> null
        }

        if (hasil != null) {
            tvRes.text = "Result\n$hasil"
        } else {
            tvRes.text = "Result\nError (Tidak bisa dibagi nol / Input kosong)"
        }
    }
}