package com.kdotj.demo.kotlinmutlichoicedialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import org.jetbrains.anko.selector
import java.util.*

/**
 * Sample Activity demonstrating the usage of an extension
 */
class MainActivity : AppCompatActivity() {

    lateinit var textViewSelection: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewSelection = findViewById(R.id.textViewSelection)

        /*
            Custom Dialog attached to an AppCompatButton via the Context
            extension function in our Util.kt file
         */
        val btnCustom = findViewById<AppCompatButton>(R.id.btnCustomDialog)
        val dogs = resources.getStringArray(R.array.custom_options)
        var currentBreed = 0
        btnCustom.setOnClickListener {

            /*
                Last argument is our function, it accepts the selection position
                from the single choice dialog as its parameter
             */
            displaySingleChoiceDialog(getString(R.string.dogs_title),
                    dogs, currentBreed, {
                currentBreed = it
                val dog = dogs[currentBreed]
                textViewSelection.text = String.format(Locale.getDefault(), getString(R.string.dogs_selection_text), dog)
            })
        }

        /*
            Anko Dialog attached to an AppCompatButton
         */
        val btnAnko = findViewById<AppCompatButton>(R.id.btnAnkoDialog)
        btnAnko.setOnClickListener {
            val fruits = resources.getStringArray(R.array.anko_options).asList()
            /*
                Anko works very similar to what we are doing, however, you lose the
                choice radio button when using selector from anko
             */
            selector(getString(R.string.fruit_title), fruits, { _, i ->
                textViewSelection.text  = String.format(Locale.getDefault(), getString(R.string.fruits_selection_text), fruits[i])
            })
        }

    }

}
