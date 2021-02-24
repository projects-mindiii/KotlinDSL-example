package com.kotlindsl

import android.content.Context
import androidx.appcompat.app.AlertDialog

/**
 * @author Avinash Kumar
 * @mail avisingh736@gmail.com
 * */

fun buildDialog(context: Context, build: AlertDialog.Builder.() -> Unit): AlertDialog {
    val builder = AlertDialog.Builder(context)
    builder.build()
    return builder.create()
}