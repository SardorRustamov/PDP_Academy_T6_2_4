package com.example.pdp_academy_t6_2_4.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pdp_academy_t6_2_4.R
import com.example.pdp_academy_t6_2_4.databinding.ActivityInfoPhoneBinding

class InfoPhoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoPhoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityInfoPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val phoneInfo = intent.getStringExtra("phoneInfo")
        val phoneName = intent.getStringExtra("phoneName")

        binding.infoPhoneTool.text= phoneName

        binding.infoPhoneText.text= phoneInfo
    }
}