package com.khalilah.englishconversations.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

data class ConversationModel(val type:String,val type_arabic:String,val dialogue:List<DialogueModel>)

//
//fun parseJson(jsonString: String): List<ConversationModel>? {
//    val gson = Gson()
//    val listType = object : TypeToken<List<ConversationModel>>() {}.type
//    return gson.fromJson<List<ConversationModel>>(jsonString, listType)
//
//}
fun parseJson(jsonString: String): ConversationModel? {
    val gson = Gson()
    return gson.fromJson(jsonString, ConversationModel::class.java)
}

// Function to read JSON file
fun readJsonFile(context: Context, fileName: String): String? {
    var json: String? = null
    try {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, Charsets.UTF_8)
    } catch (ioException: IOException) {
        ioException.printStackTrace()
    }
    return json
}