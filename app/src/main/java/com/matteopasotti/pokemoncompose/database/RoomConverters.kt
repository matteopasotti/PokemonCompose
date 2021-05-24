package com.matteopasotti.pokemoncompose.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomConverters {

    var gson = Gson()

    @TypeConverter
    fun fromString(json: String?): List<String>? {
        if(json == null) {
            return null
        }
        val obj =  object : TypeToken<List<String>>(){}.type
        return gson.fromJson(json, obj)
    }

    @TypeConverter
    fun fromList(list: List<String?>?): String? {
        if(list == null) {
            return null
        }
        return gson.toJson(list)
    }
}