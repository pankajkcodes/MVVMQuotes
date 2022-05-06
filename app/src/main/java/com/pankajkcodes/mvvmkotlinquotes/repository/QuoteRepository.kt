package com.pankajkcodes.mvvmkotlinquotes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pankajkcodes.mvvmkotlinquotes.dao.QuoteDao
import com.pankajkcodes.mvvmkotlinquotes.models.Quote

class QuoteRepository(private val quoteDao: QuoteDao) {


    fun getQuotes(): LiveData<List<Quote>> {


        return quoteDao.getQuotes()
    }

    suspend fun insertQuotes(quote: Quote) {

        quoteDao.insertQuote(quote)
    }


}