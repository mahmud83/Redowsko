package com.android.redowsko.util.sharedpref

import android.content.Context
import android.content.SharedPreferences

class UserDetail(context: Context) {

    val sp:SharedPreferences = context.getSharedPreferences("USER_DETAIL",0)
    val edit:SharedPreferences.Editor = sp.edit()

    fun fillAllData(name:String?, position:String?, email:String?, phone:String?, city:String?, address:String?, gender:String?){

        edit.putString("name",name)
        edit.putString("position",position)
        edit.putString("email",email)
        edit.putString("phone",phone)
        edit.putString("city",city)
        edit.putString("address",address)
        edit.putString("gender",gender)
        edit.commit()

    }

    fun setName(name:String?){
        edit.putString("name",name)
        edit.commit()
    }

    fun setPosition(position:String?){
        edit.putString("position",position)
        edit.commit()
    }

    fun setEmail(email:String?){
        edit.putString("email",email)
        edit.commit()
    }

    fun setPhone(phone:String?){
        edit.putString("phone",phone)
        edit.commit()
    }

    fun setCity(city:String?){
        edit.putString("city",city)
        edit.commit()
    }

    fun setAddress(address:String?){
        edit.putString("address",address)
        edit.commit()
    }

    fun setGender(gender:String?){
        edit.putString("gender",gender)
        edit.commit()
    }

    fun getName() : String?{
        return sp.getString("name",null) ?: null
    }

    fun getPosition() : String?{
        return sp.getString("position",null) ?: null
    }

    fun getEmail() : String?{
        return sp.getString("email",null) ?: null
    }

    fun getPhone() : String?{
        return sp.getString("phone",null) ?: null
    }

    fun getCity() : String?{
        return sp.getString("city",null) ?: null
    }

    fun getAddress() : String?{
        return sp.getString("address",null) ?: null
    }

    fun getGender() : String?{
        return sp.getString("gender",null) ?: null
    }

    fun clearData(){
        edit.clear()
        edit.commit()
    }

}