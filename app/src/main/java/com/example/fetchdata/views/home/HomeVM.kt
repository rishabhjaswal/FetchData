package com.example.fetchdata.views.home

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.fetchdata.MainActivity
import com.example.fetchdata.R
import com.example.fetchdata.utils.navigateWithId

class HomeVM : ViewModel() {

    fun onClick(view:View){
        when(view.id){
            R.id.btnLogin ->{
                view.navigateWithId(R.id.action_home_to_second)
            }
        }
    }
}

