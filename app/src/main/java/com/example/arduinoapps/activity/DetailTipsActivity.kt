package com.example.arduinoapps.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arduinoapps.databinding.ActivityDetailTipsBinding
import com.example.arduinoapps.databinding.ActivityMainBinding

class DetailTipsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTipsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back()
    }

    private fun back(){
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}