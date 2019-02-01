package com.example.lab4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class web : AppCompatActivity() {

    var mywebview: WebView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        mywebview = findViewById<WebView>(R.id.vista)//Tomamos por el id Vista
        mywebview!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {//Hacemos overrie al metodo shouldOverrideUrLoading
                view?.loadUrl(url)
                return true
            }
        }
        mywebview!!.loadUrl(getIntent().getStringExtra("link"))

        home.setOnClickListener{//enviamos a correo//Definimos para boton home
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}
