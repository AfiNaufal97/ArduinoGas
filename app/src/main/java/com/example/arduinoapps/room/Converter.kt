package com.example.arduinoapps.room

import androidx.room.TypeConverter
import java.util.Date

class Converter {
    @TypeConverter
    fun fromTimeStamp(value : Long) : Date?{
        return if (value == null) null  else Date(value)
    }

    @TypeConverter
    fun dateToTimeStamp(date : Date) : Long?{
        return if(date == null ) null else date.time
    }
}