package com.kdotj.demo.kotlinmutlichoicedialog

import android.content.Context
import android.support.v7.app.AlertDialog

fun Context.displaySingleChoiceDialog(title: String, options: Array<String>, currentSelection: Int, operation: (which: Int) -> Unit) {
    val optionsDialog = AlertDialog.Builder(this, R.style.AppTheme_Dialog)
    optionsDialog.setTitle(title)
    optionsDialog.setSingleChoiceItems(options, currentSelection, { dialog, which ->
        run {
            operation(which)
            dialog.dismiss()
        }
    })
    optionsDialog.create().show()
}