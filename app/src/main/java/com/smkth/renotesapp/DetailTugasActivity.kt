package com.smkth.renotesapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class DetailTugasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tugas)

        val btnBack = findViewById<android.widget.ImageButton>(R.id.btnBack)
        val btnIngatkan = findViewById<MaterialButton>(R.id.btnIngatkan)
        val btnSelesai = findViewById<MaterialButton>(R.id.btnSelesai)

        btnBack.setOnClickListener { finish() }

        btnIngatkan.setOnClickListener {
            // TODO: Tampilkan notifikasi atau dialog pengingat
        }

        btnSelesai.setOnClickListener {
            // TODO: Tandai tugas sebagai selesai (update database atau UI)
        }
    }
}
