package com.example.arduinoapps.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "history")
data class History(
   @PrimaryKey var id_history : Int? = null,
    var heartRate : Int? = null,
    var spo : Double? = null,
    var temperature : Double? = null,
    var result : String? = null,
    var time_stamp : Date? = null
)
