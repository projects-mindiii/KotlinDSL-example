package com.kotlindsl

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun buildDialog(context: Context, build: AlertDialog.Builder.() -> Unit): AlertDialog {
    val builder = AlertDialog.Builder(context)
    builder.build()
    return builder.create()
}