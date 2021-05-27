package com.example.lab1mnd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import java.lang.Math.*

class MainActivity : AppCompatActivity() {
    private var input: EditText? = null
    private var btn: Button? = null
    private var res: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.input = findViewById(R.id.editTextNum)
        this.btn = findViewById(R.id.button)
        this.res = findViewById(R.id.textView)

        this.btn?.setOnClickListener {
            task()
        }
    }

    fun task() {
        val n = this.input?.text.toString().toLong()
        this.res?.text = this.fermatFactorization(n).toString()
    }

    fun fermatFactorization(n: Long): List<Long>? {
        if (n % 2 == 0L) return listOf(2L, n / 2L)
        if (n <= 0L) return null

        var a = ceil(sqrt(n.toDouble()))
        var b = 0.0

        if (a * a == n.toDouble()) return listOf(a.toLong(), a.toLong())

        while(true) {
            val b1 = a * a - n
            b = floor(sqrt(b1))
            if (b1 == b * b) break else a++
        }

        return listOf((a - b).toLong(), (a + b).toLong())
    }
}