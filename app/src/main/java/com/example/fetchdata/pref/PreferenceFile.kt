package com.example.fetchdata.pref

import android.content.SharedPreferences
import com.google.gson.Gson

object PreferenceFile {

    private val editor: SharedPreferences.Editor by lazy { PrefModule.getEditor }
    private val sharedPreferences: SharedPreferences by lazy { PrefModule.getPref }

    fun storeKey(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun storeBoolKey(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun retrieveKey(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun retrieveBoolKey(key: String): Boolean? {
        return sharedPreferences.getBoolean(key, false)
    }

    fun <T> storeObject(key: String, data: T) {
        editor.putString(key, Gson().toJson(data))
        editor.apply()
    }


    fun clearPreference() {
        editor.clear()
        editor.apply()
//    openActivity(Intent(this, Login::class.java), true)
    }

/*
    fun retrieveLoginData(): LoginResponse {

        return Gson().fromJson(
            sharedPreferences.getString(loginDataKey, "")!!,
            LoginResponse::class.java
        )
    }
*/
}