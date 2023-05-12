package com.example.arduinoapps.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.arduinoapps.R
import com.example.arduinoapps.activity.MainActivity
import com.example.arduinoapps.activity.register.RegisterActivity
import com.example.arduinoapps.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private val login: LoginViewModel by viewModels()
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        funLoading()
        clickButtonRegister()
        setLogin()
        clickButtonLogin()
    }

    private fun funLoading() {
        login.loading.observe(this) {
            if (it) {
                binding.loading.visibility = View.VISIBLE
                binding.btnLogin.visibility = View.GONE
            } else {
                binding.loading.visibility = View.GONE
                binding.btnLogin.visibility = View.VISIBLE
            }
        }
    }

    private fun clickButtonLogin() {
        binding.btnLogin.setOnClickListener(this)

    }

    private fun loginUser() {
        login.setLoading(true)
        auth = Firebase.auth
        auth.signInWithEmailAndPassword(
            login.email.value.toString(),
            login.password.value.toString()
        )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val user = auth.currentUser
                    login.setLoading(false)
                    startActivity(Intent(this, MainActivity::class.java))

                } else {
                    Log.d("Error", "Error Gaes")
                    login.setLoading(false)
                }
            }

    }

    private fun setLogin() {
        login.email.observe(this) {
            binding.etUsername.setText(it)
        }
        login.password.observe(this) {
            binding.etPassword.setText(it)
        }
    }

    private fun clickButtonRegister() {
        binding.tvCreateAccount.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tvCreateAccount -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            R.id.btnLogin ->{
                login.setEmail(binding.etUsername.text.toString())
                login.setEmail(binding.etPassword.text.toString())
                loginUser()
            }
        }
    }

}