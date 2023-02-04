package com.example.pdp_academy_t6_2_4.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pdp_academy_t6_2_4.R
import com.example.pdp_academy_t6_2_4.adapter.PhoneAdapter
import com.example.pdp_academy_t6_2_4.databese.PhoneDataBase
import com.example.pdp_academy_t6_2_4.databinding.ActivityPhoneTypeInfoBinding
import com.example.pdp_academy_t6_2_4.model.Phone

class PhoneTypeInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhoneTypeInfoBinding
    private lateinit var data : PhoneDataBase
    private lateinit var adapter: PhoneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPhoneTypeInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        data = PhoneDataBase(this)

        val txt = intent.getStringExtra("onClickPhone").toString()
        binding.phoneTool.text = txt

        val typePhone = data.typePhone(txt)

        adapter = PhoneAdapter(typePhone){
            position->
            val intent = Intent(this, InfoPhoneActivity::class.java)
            val phoneName = typePhone[position].phoneName
            val phoneInfo = typePhone[position].phoneInfo

            intent.putExtra("phoneName", phoneName)
            intent.putExtra("phoneInfo", phoneInfo)
            startActivity(intent)
        }

        binding.rv.adapter=adapter
    }
}