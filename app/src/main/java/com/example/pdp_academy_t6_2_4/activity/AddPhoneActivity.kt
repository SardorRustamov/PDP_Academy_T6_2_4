package com.example.pdp_academy_t6_2_4.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pdp_academy_t6_2_4.R
import com.example.pdp_academy_t6_2_4.databese.PhoneDataBase
import com.example.pdp_academy_t6_2_4.databinding.ActivityAddPhoneBinding
import com.example.pdp_academy_t6_2_4.model.Phone

class AddPhoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPhoneBinding
    private lateinit var dataBase: PhoneDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBase = PhoneDataBase(this)

        val phoneTypes = intent.getStringExtra("textClick").toString()

        binding.addPhone.setOnClickListener(View.OnClickListener {
            val phoneName = binding.phoneName.text.toString()
            val phoneFeatures = binding.phoneFeatures.text.toString()

            if (phoneName.trim().isNotEmpty() && phoneFeatures.trim().isNotEmpty()) {
                val phone = Phone(phoneType = phoneTypes, phoneName = phoneName, phoneInfo = phoneFeatures)

                dataBase.addPhone(phone)
                Toast.makeText(this, "Successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }
}