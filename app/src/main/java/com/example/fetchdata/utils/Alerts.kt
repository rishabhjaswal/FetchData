package com.example.fetchdata.utils


import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.example.fetchdata.R
import com.example.fetchdata.databinding.AlertLayoutBinding
import com.example.fetchdata.databinding.ProgressLayoutBinding


//ErrorAlert

fun Context.alert(message: String) {
    try {
        val builder = AlertDialog.Builder(this)
        val layoutView = AlertLayoutBinding.inflate(LayoutInflater.from(this), null, false)
        builder.setCancelable(false)
        builder.setView(layoutView.root)
        val dialog = builder.create()

        layoutView.tvMessage.text = message
        layoutView.tvOkButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.show()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

//Loader

private var customDialog: AlertDialog? = null

fun Context.showProgress() {
    hideProgress()
    val customAlertBuilder = AlertDialog.Builder(this)
    val customAlertView =
        ProgressLayoutBinding.inflate(LayoutInflater.from(this), null, false)
    customAlertBuilder.setView(customAlertView.root)
    customAlertBuilder.setCancelable(false)
    customDialog = customAlertBuilder.create()

    customDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    customDialog!!.show()
}

fun hideProgress() {
    if (customDialog != null && customDialog?.isShowing!!) {
        customDialog?.dismiss()
    }
}


