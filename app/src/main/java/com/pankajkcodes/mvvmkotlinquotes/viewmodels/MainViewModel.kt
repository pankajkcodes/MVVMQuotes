package com.pankajkcodes.mvvmkotlinquotes.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pankajkcodes.mvvmkotlinquotes.models.Quote
import com.pankajkcodes.mvvmkotlinquotes.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes(): LiveData<List<Quote>> {


        return quoteRepository.getQuotes()
    }


    fun insertQuote(quote: Quote) {
        viewModelScope.launch(Dispatchers.IO) {

            quoteRepository.insertQuotes(quote)

        }
    }


}