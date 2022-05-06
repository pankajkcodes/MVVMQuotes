package com.pankajkcodes.mvvmkotlinquotes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.pankajkcodes.mvvmkotlinquotes.R
import com.pankajkcodes.mvvmkotlinquotes.databinding.ActivityMainBinding
import com.pankajkcodes.mvvmkotlinquotes.db.QuoteDatabase
import com.pankajkcodes.mvvmkotlinquotes.models.Quote
import com.pankajkcodes.mvvmkotlinquotes.repository.QuoteRepository
import com.pankajkcodes.mvvmkotlinquotes.viewmodels.MainViewModel
import com.pankajkcodes.mvvmkotlinquotes.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)


        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(repository)
        )[MainViewModel::class.java]


        //Toast.makeText(this@MainActivity, e.message.toString(), Toast.LENGTH_SHORT).show()


        mainViewModel.getQuotes().observe(this, {
            binding.quotes = it.toString()
        })

        binding.btnAddQuote.setOnClickListener {

            val quote = Quote(0,"For Testing","No Author")
            mainViewModel.insertQuote(quote)
        }
    }
}