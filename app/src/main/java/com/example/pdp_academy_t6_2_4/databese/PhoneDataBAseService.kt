package com.example.pdp_academy_t6_2_4.databese

import com.example.pdp_academy_t6_2_4.model.Phone

interface PhoneDataBAseService {
    fun addPhone(phone: Phone)
    fun typePhone(type:String) : List<Phone>
}