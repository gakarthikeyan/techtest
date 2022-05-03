package com.example.techtest.utility

import android.app.Dialog
import android.content.Context
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
}