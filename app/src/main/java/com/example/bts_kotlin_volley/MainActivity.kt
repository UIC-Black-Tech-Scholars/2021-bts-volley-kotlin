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
        val request = StringRequest(
                Request.Method.GET,
                textUrl,
                Response.Listener { response ->
                    try {
                        Log.i("MainActivity", response)
                        firstText.setText(response)

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { error ->
                    error.printStackTrace()
                }
        )

        requestQueue?.add(request)

        val ImageUrl = "https://pastebin.com/raw/AjEDaQ4V"

        val request2 = StringRequest(
                Request.Method.GET,
                ImageUrl,
                Response.Listener { response ->
                    try {
                        Log.i("MainActivity", response)
                        val decodedString: ByteArray = Base64.decode(response.substring(21), Base64.DEFAULT)
                        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
                        imageView.setImageBitmap(decodedByte)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { error ->
                    error.printStackTrace()
                }
        )

        requestQueue?.add(request2)
    }
}