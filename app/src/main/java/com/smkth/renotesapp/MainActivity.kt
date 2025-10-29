package com.smkth.renotesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tambahBtn = findViewById<ExtendedFloatingActionButton>(R.id.btnTambah)
        tambahBtn.setOnClickListener {
            // Aksi saat tombol tambah ditekan
        }
    }
}
