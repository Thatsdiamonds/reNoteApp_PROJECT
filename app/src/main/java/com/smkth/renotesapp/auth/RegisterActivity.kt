package com.smkth.renotesapp.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.smkth.renotesapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        // Tombol ke halaman Register
        binding.btnToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val uid = auth.currentUser?.uid ?: return@addOnCompleteListener
                            val user = hashMapOf("name" to name, "email" to email)
                            db.collection("users").document(uid).set(user)

                            // Sign out agar user tidak otomatis login
                            auth.signOut()

                            Toast.makeText(this, "Registrasi berhasil, silakan login", Toast.LENGTH_LONG).show()

                            // Tambahkan sedikit delay agar signOut benar-benar selesai
                            binding.btnRegister.postDelayed({
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            }, 300)
                            finishAffinity()
                        }

                    }
            } else {
                Toast.makeText(this, "Lengkapi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
