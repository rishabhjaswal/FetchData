package com.example.fetchdata.pref

import android.content.Context
import android.content.SharedPreferences
import com.example.fetchdata.MainActivity

object PrefModule {

    val getPref: SharedPreferences by lazy {
        MainActivity.context.get()!!.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
    }

    val getEditor: SharedPreferences.Editor by lazy {
        getPref.edit()
    }


}