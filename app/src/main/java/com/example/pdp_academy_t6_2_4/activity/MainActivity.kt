package com.example.pdp_academy_t6_2_4.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pdp_academy_t6_2_4.R
import com.example.pdp_academy_t6_2_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addFood.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PhoneTypesActivity::class.java)
            startActivity(intent)
        })

        binding.foodList.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PhonesActivity::class.java)
            startActivity(intent)
        })
    }
}