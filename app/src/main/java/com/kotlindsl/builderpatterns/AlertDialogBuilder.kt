package com.kotlindsl.builderpatterns

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.kotlindsl.markers.DSLExample

@DSLExample
class AlertDialogBuilder {
    var context: Context? = null
    var title = ""
    var message = ""
    var positiveText = ""
    var negativeText = ""
    var onPositiveClickListener: (DialogInterface, Int) -> Unit = { _: DialogInterface, _: Int -> }
    var onNegativeClickListener: (DialogInterface, Int) -> Unit = { _: DialogInterface, _: Int -> }


    inline fun with(context: () -> Context) {
        this.context = context()
    }

    inline fun title(title: () -> String) {
        this.title = title()
    }

    inline fun message(message: () -> String) {
        this.message = message()
    }

    inline fun positiveText(positiveText: () -> String) {
        this.positiveText = positiveText()
    }

    inline fun negativeText(negativeText: () -> String) {
        this.negativeText = negativeText()
    }

    fun onPositiveClickListener(onPositiveClickListener: (DialogInterface, Int) -> Unit) {
        this.onPositiveClickListener = onPositiveClickListener
    }

    fun onNegativeClickListener(onNegativeClickListener: (DialogInterface, Int) -> Unit) {
        this.onNegativeClickListener = onNegativeClickListener
    }

    fun build(): AlertDialog = AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setNegativeButton(negativeText) { di, i -> onNegativeClickListener(di, i) }
        .setPositiveButton(positiveText) { di, i -> onPositiveClickListener(di, i) }
        .create()

}

fun buildAlertDialog(lambda: AlertDialogBuilder.() -> Unit) = AlertDialogBuilder().apply(lambda).build()