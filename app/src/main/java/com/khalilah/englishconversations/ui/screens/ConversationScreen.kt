package com.khalilah.englishconversations.ui.screens

import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.khalilah.englishconversations.R
import com.khalilah.englishconversations.components.ConversationDetailsCard
import com.khalilah.englishconversations.models.ConversationModel
import com.khalilah.englishconversations.models.readJsonFile
import com.khalilah.englishconversations.viewmodels.MyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationScreen(navController: NavController,viewModel: MyViewModel) {
    val context = LocalContext.current
    val textToSpeech = remember { TextToSpeech(context, null) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(

                title = {
                    Text(text = viewModel.conversationType!!.titleArabic,fontFamily = FontFamily(
                        Font(R.font.honor)
                    )
                    )
                },
                navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Back to main menu", modifier = Modifier
                        .clickable {
                            navController.navigateUp()
                        }
                        .size(25.dp) )
                }
            )
        },
    ) { innerPadding ->
//Column(Modifier.padding(paddingValues = innerPadding)) {
   Log.d("listSize", viewModel.conversationDetails!!.dialogue[1].toString())
//}
   LazyColumn(Modifier.padding(innerPadding)){

       items(viewModel.conversationDetails!!.dialogue.size){index->
         ConversationDetailsCard(dialogueModel = viewModel.conversationDetails!!.dialogue[index]){
             onVoiceClick( viewModel.conversationDetails!!.dialogue[index].english,textToSpeech=textToSpeech)
         }
       }
   }
    }

    DisposableEffect(Unit) {
        onDispose {
            textToSpeech.shutdown()
        }
    }

}

fun onVoiceClick(text:String,textToSpeech: TextToSpeech){
    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
}


//      Column() {
//          Spacer(modifier = Modifier.height(300.dp))
//          Text(text = viewModel.conversationType!!.titleArabic?:"")
//      }