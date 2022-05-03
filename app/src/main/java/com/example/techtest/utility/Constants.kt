package com.example.techtest.utility

import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
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
                if (!dialog?.isShowing!!) {
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
            if (dialog != null && dialog?.isShowing!!) {
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
    fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}