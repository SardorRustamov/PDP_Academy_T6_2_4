package com.example.pdp_academy_t6_2_4.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pdp_academy_t6_2_4.databinding.ActivityPhoneTypesBinding

class PhoneTypesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneTypesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPhoneTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onClick(view: View) {
        val textClick: TextView = view as TextView
        val s: String = textClick.text.toString()
        val intent = Intent(this, AddPhoneActivity::class.java)
        intent.putExtra("textClick", s)
        startActivity(intent)
    }
}