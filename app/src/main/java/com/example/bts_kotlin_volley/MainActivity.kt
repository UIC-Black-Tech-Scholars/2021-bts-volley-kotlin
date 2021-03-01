package com.example.bts_kotlin_volley

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException


class MainActivity : AppCompatActivity() {

    private lateinit var firstText: TextView
    private lateinit var imageView: ImageView
    private var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        imageView = findViewById(R.id.imageView)
        firstText = findViewById(R.id.textView)
        val secondText = findViewById<TextView>(R.id.textView2)

        requestQueue = Volley.newRequestQueue(this)

        button.setOnClickListener { makeWebRequests() }

    }

    private fun makeWebRequests() {

        val textUrl = "https://pastebin.com/raw/HNGezyyW"


        val ImageUrl = "https://pastebin.com/raw/AjEDaQ4V"

    }
}