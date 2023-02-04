package com.example.pdp_academy_t6_2_4.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.pdp_academy_t6_2_4.R
import com.example.pdp_academy_t6_2_4.databinding.ActivityPhonesBinding

class PhonesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhonesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPhonesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun onClickPhone(view: View) {
        val st = view as TextView
        val text = st.text

        val intent = Intent(this, PhoneTypeInfoActivity::class.java)
        intent.putExtra("onClickPhone", text)
        startActivity(intent)
    }
}