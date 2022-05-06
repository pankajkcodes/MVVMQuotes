package com.pankajkcodes.mvvmkotlinquotes.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pankajkcodes.mvvmkotlinquotes.models.Quote


@Dao
interface QuoteDao {


    @Query("SELECT * FROM quote")
    fun getQuotes() : LiveData<List<Quote>>


    @Insert
    suspend fun  insertQuote(quote: Quote)


}