package com.example.arduinoapps.room

import android.content.Context
import androidx.room.*
import com.example.arduinoapps.model.History

@Database(entities = [History::class], version = 1)
@TypeConverters(Converter::class)
abstract class MyDatabase : RoomDatabase(){
    abstract fun historyDao():HistoryDao

    companion object {
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase? {
            if (INSTANCE == null) {
                synchronized(MyDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java, "MyDatabase2" // Database Name
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}