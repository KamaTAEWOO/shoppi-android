package com.nknd.shoppi_android

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}