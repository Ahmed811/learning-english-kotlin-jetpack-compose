package com.khalilah.englishconversations

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.android.gms.ads.MobileAds
import com.khalilah.englishconversations.models.ConversationModel
import com.khalilah.englishconversations.models.parseJson
import com.khalilah.englishconversations.models.readJsonFile
import com.khalilah.englishconversations.ui.theme.EnglishConversationsTheme

class MainActivity : ComponentActivity() {
  //  lateinit var data:List<ConversationModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      MobileAds.initialize(this) {}
//        val jsonList = readJsonFile(this, "greeting.json")
//        jsonList?.let {
//            data= parseJson(it)!!
//            Log.d("mydata",data[0].dialogue.get(0).english)
//        }
        setContent {
            EnglishConversationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Text(text = data.get(0).dialogue.toString())
                    ConversationApp()
                }
            }
        }
    }

}


