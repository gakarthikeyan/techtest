package com.example.techtest.utility

import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.techtest.BuildConfig
import com.example.techtest.R

object Constants {

    private var dialog: Dialog? = null

    // progress dialog for global access
    fun showProgressDialog(activity: Context?)
    {
        try {
            cancelProgressDialog()
            if (dialog == null) {
                dialog = activity?.let { Dialog(it) }
                dialog?.setContentView(R.layout.layout_progress_dialog)
                dialog?.window?.setBackgroundDrawableResource(
                    android.R.color.transparent)
                dialog?.setCancelable(false)
                dialog?.show()
            } else {
                if (dialog?.isShowing == false) {
                    dialog = activity?.let { Dialog(it) }
                    dialog?.setContentView(R.layout.layout_progress_dialog)
                    dialog?.window?.setBackgroundDrawableResource(
                        android.R.color.transparent)
                    dialog?.setCancelable(false)
                    dialog?.show()
                }
            }
        } catch (e: Exception) {
            if(BuildConfig.DEBUG) {
                e.printStackTrace()
            }

        }
    }
    //cancel progress
    fun cancelProgressDialog() {
        try {
            if (dialog != null && dialog?.isShowing == true) {
                dialog?.dismiss()
                dialog = null
            }
        } catch (e: Exception) {
            if(BuildConfig.DEBUG) {
                e.printStackTrace()
            }

        }
    }

//    check internet availability
fun isNetworkAvailable(context: Context) =
    (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
        getNetworkCapabilities(activeNetwork)?.run {
            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    || hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        } ?: false
    }
}