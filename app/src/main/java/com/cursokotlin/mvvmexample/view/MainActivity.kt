package com.cursokotlin.mvvmexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.cursokotlin.mvvmexample.databinding.ActivityMainBinding
import com.cursokotlin.mvvmexample.viewmodel.QuoteViewModel

/**
 * https://cursokotlin.com/mvvm-en-android-con-kotlin-livedata-y-view-binding-android-architecture-components/
 */


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding





    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /** Se asigna al layout completo un evento OnClickListener que indicará al viewModel que lance el método randomQuote() */
        binding.root.setOnClickListener { quoteViewModel.randomQuote() }


        /** Utilizamos live data. Nos conectamos a través del patrón "observer" para que cuando haya aun cambio, la
         * activity se entere.
         * El patrón de comportamiento observer permite que las vistas tvQuote y tvAuthor queden vinculadas al
         * quoteViewModel de modo que cuando este cambia se actualicen automáticamente.
         *
         *
         **/
        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })
    }

}