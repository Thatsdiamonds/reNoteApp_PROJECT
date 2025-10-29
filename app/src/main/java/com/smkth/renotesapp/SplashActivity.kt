package com.smkth.renotesapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.smkth.renotesapp.auth.LoginActivity
import com.smkth.renotesapp.auth.RegisterActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = FirebaseAuth.getInstance()

        Handler(Looper.getMainLooper()).postDelayed({
            val currentUser = auth.currentUser

            if (currentUser != null) {
                // ✅ Jika sudah login → langsung ke MainActivity
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // 🚪 Jika belum login → arahkan ke Register (atau bisa LoginActivity)
                startActivity(Intent(this, RegisterActivity::class.java))
            }

            overridePendingTransition(
                R.anim.slide_in_bottom,   // animasi masuk
                R.anim.fade_out           // animasi keluar
            )
            finish()
        }, 2000)
    }
}
