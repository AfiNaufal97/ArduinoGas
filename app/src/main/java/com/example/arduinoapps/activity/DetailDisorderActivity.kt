package com.example.arduinoapps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arduinoapps.databinding.ActivityDetailDisorderBinding

class DetailDisorderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDisorderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDisorderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back()
    }

    private fun back(){
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}