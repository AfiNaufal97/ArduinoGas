package com.example.arduinoapps.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arduinoapps.activity.login.LoginActivity
import com.example.arduinoapps.databinding.ActivitySplashBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        start()
        supportActionBar?.hide()
    }

    private fun start() {
        auth = Firebase.auth
        val currentUser = auth.currentUser
        val animateRunnable = Runnable {
            if (currentUser != null) {
                startActivity(Intent(this, MainActivity::class.java).also { finish() })
            } else {
                startActivity(Intent(this, LoginActivity::class.java).also { finish() })

            }
        }
        binding.splashView.postDelayed(animateRunnable, 3000)

    }
}