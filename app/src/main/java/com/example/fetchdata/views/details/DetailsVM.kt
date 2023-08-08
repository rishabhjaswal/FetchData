package com.example.fetchdata.views.details

import android.os.Bundle
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.fetchdata.models.PostResponseItem

class DetailsVM : ViewModel() {

    var bundle: Bundle? = null

    var userid = ObservableField("")
    var id = ObservableField("")
    var title = ObservableField("")
    var body = ObservableField("")

    fun setData(){

        val selected = bundle?.getSerializable("selected") as PostResponseItem

        userid.set(selected.userId.toString())
        id.set(selected.id.toString())
        title.set(selected.title.toString())
        body.set(selected.body.toString())
    }

}



