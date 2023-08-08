package com.example.fetchdata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {



    companion object {
        lateinit var context: WeakReference<Context>
    }


    override fun onStart() {
        super.onStart()
        context = WeakReference(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}