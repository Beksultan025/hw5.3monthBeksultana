package com.example.hw54

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw54.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var count = 0
    private var switch = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        logic()
    }

    private fun logic() {
        binding.matBtn.setOnClickListener {
            when (switch) {
                true -> {
                    if (count != 10) {
                        count++
                        binding.textTv.text = count.toString()
                    } else {
                        switch = false
                        count--
                        binding.textTv.text = count.toString()
                    }
                    if (count == 10) binding.matBtn.text = "-1"
                }
                false -> {
                    if (count != 0) {
                        count--
                        binding.textTv.text = count.toString()
                    } else {
                        val intent = Intent(this, SecondActivity::class.java)
                        startActivity(intent)
                    }
                    if (count == 0 && !switch) binding.matBtn.text = "Open Second Activity"
                }
            }
        }
    }
}