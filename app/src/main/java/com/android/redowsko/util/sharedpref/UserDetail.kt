package com.android.redowsko.util.sharedpref

import android.content.Context
import android.content.SharedPreferences

class UserDetail(context: Context) {

    val sp:SharedPreferences = context.getSharedPreferences("USER_DETAIL",0)
    val edit:SharedPreferences.Editor = sp.edit()

    fun fillAllData(name:String?, position:String?, email:String?, phone:String?, city:String?, address:String?, gender:String?, idSurverior:Int?){

        edit.putString("name",name)
        edit.putString("position",position)
        edit.putString("email",email)
        edit.putString("phone",phone)
        edit.putString("city",city)
        edit.putString("address",address)
        edit.putString("gender",gender)
        edit.putInt("idSurverior",idSurverior!!)

    }

    fun setName(name:String?){
        edit.putString("name",name)
    }

    fun setPosition(position:String?){
        edit.putString("position",position)
    }

    fun setEmail(email:String?){
        edit.putString("email",email)
    }

    fun setPhone(phone:String?){
        edit.putString("phone",phone)
    }

    fun setCity(city:String?){
        edit.putString("city",city)
    }

    fun setAddress(address:String?){
        edit.putString("address",address)
    }

    fun setGender(gender:String?){
        edit.putString("gender",gender)
    }

    fun setIdSurverior(idSurverior:Int?){
        edit.putInt("idSurverior",idSurverior!!)
    }

    fun getName() : String{
        return sp.getString("name",null)
    }

    fun getPosition() : String{
        return sp.getString("position",null)
    }

    fun getEmail() : String{
        return sp.getString("email",null)
    }

    fun getPhone() : String{
        return sp.getString("phone",null)
    }

    fun getCity() : String{
        return sp.getString("city",null)
    }

    fun getAddress() : String{
        return sp.getString("address",null)
    }

    fun getGender() : String{
        return sp.getString("gender",null)
    }

    fun getIdSurverior() : Int{
        return sp.getInt("idSurverior",0)
    }

}