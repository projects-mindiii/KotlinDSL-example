package com.kotlindsl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kotlindsl.builderpatterns.buildAlertDialog
import com.kotlindsl.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnShowDialog.setOnClickListener {

            /**
             * Create and show alert dialog with kotlin DSL
             * */
            /*buildDialog(this) {
                setTitle("Hello World!")
                setMessage("This is kotlin dsl example with extension function")
                setPositiveButton("Ok") { di, _ -> di.dismiss() }
            }.show()*/

            /**
             * Create and show alert dialog with kotlin DSL using inline function
             * */
            buildAlertDialog {
                with { this@MainActivity }
                title { "Hello World!" }
                message { "This is kotlin dsl example with inline function" }
                positiveText { "Ok" }
                onPositiveClickListener { di, _ -> di.dismiss() }
            }.show()
        }
    }
}