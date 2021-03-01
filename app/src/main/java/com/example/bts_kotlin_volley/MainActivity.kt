package com.example.bts_kotlin_volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    private var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val image = findViewById<ImageView>(R.id.imageView)
        val firstText = findViewById<TextView>(R.id.textView)
        val secondText = findViewById<TextView>(R.id.textView2)

        requestQueue = Volley.newRequestQueue(this)

        button.setOnClickListener { makeWebRequests() }

    }

    private fun makeWebRequests(){

        val textUrl = "https://pastebin.com/raw/HNGezyyW"


        val ImageUrl = "https://pastebin.com/raw/AjEDaQ4V"

    }
}