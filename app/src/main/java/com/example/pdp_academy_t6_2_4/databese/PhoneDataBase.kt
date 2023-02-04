package com.example.pdp_academy_t6_2_4.databese

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.pdp_academy_t6_2_4.model.Phone

class PhoneDataBase(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION), PhoneDataBAseService
{
    companion object{
        const val DB_NAME = "phone_table"
        const val DB_VERSION = 1

        const val TABLE_NAME = "phone"
        const val PHONE_ID = "id"
        const val PHONE_TYPE_NAME = "phone_type_name"
        const val PHONE_NAME = "phone_name"
        const val PHONE_FEATURES = "phone_features"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query = "create table $TABLE_NAME($PHONE_ID integer not null primary key autoincrement unique, $PHONE_TYPE_NAME text not null, $PHONE_NAME text not null, $PHONE_FEATURES text not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    override fun addPhone(phone: Phone) {
        val database = this.writableDatabase
        val contentVal = ContentValues()
        contentVal.put(PHONE_TYPE_NAME, phone.phoneType)
        contentVal.put(PHONE_NAME, phone.phoneName)
        contentVal.put(PHONE_FEATURES, phone.phoneInfo)
        contentVal.put(PHONE_TYPE_NAME, phone.phoneType)

        database.insert(TABLE_NAME, null, contentVal)
    }

    override fun typePhone(type: String): List<Phone> {
        val list1 = ArrayList<Phone>()
        val database1 = this.readableDatabase

        val query1 = "select * from $TABLE_NAME where $PHONE_TYPE_NAME= '$type' "


        val cursor1 =database1.rawQuery(query1, null)
        if (cursor1.moveToFirst()){
            do {
                val id = cursor1.getInt(0)
                val typePhoneName = cursor1.getString(1)
                val phoneName = cursor1.getString(2)
                val phoneFeatures = cursor1.getString(3)

                val phone = Phone(id, typePhoneName, phoneName, phoneFeatures)
                list1.add(phone)
            }while (cursor1.moveToNext())
        }

        return list1

    }
}