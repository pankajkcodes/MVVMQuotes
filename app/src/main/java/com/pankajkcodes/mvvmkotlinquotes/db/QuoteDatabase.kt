package com.pankajkcodes.mvvmkotlinquotes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pankajkcodes.mvvmkotlinquotes.dao.QuoteDao
import com.pankajkcodes.mvvmkotlinquotes.models.Quote


@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao


    companion object {

        @Volatile
        var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuoteDatabase::class.java,
                    "quoteDatabase"
                ).createFromAsset("quotes.db")
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}