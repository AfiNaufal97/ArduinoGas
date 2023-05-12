package com.example.arduinoapps.activity.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.arduinoapps.activity.MainActivity
import com.example.arduinoapps.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val register: RegisterViewModel by viewModels()
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setEmail()
        setLoading()
        setPassword()
        clickButton()
    }

    private fun setLoading() {
        register.loading.observe(this) {
            if (it) {
                binding.loading.visibility = View.VISIBLE
                binding.btnReg.visibility = View.GONE
            } else {
                binding.loading.visibility = View.GONE
                binding.btnReg.visibility = View.VISIBLE
            }
        }
    }

    private fun clickButton() {
        binding.btnReg.setOnClickListener {
            register.setEmail(binding.inEmail.text.toString())
            register.setPassword(binding.inPassword.text.toString())
            register()
        }
    }


    private fun setPassword() {
        register.password.observe(this) {
            binding.inPassword.setText(it)
        }
    }

    private fun setEmail() {
        register.email.observe(this) {
            binding.inEmail.setText(it)
        }
    }

    private fun register() {
        register.setLoading(true)
        auth = Firebase.auth
        auth.createUserWithEmailAndPassword(
            register.email.value.toString(),
            register.password.value.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    register.setLoading(false)
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Log.d("Error", "Error Gaes")
                    register.setLoading(false)
                }
            }
    }
}