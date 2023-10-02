package com.khalilah.englishconversations

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.khalilah.englishconversations.models.ConversationModel
import com.khalilah.englishconversations.models.parseJson
import com.khalilah.englishconversations.models.readJsonFile
import com.khalilah.englishconversations.ui.screens.ConversationScreen
import com.khalilah.englishconversations.ui.screens.ConversationsListScreen
import com.khalilah.englishconversations.viewmodels.MyViewModel

@Composable
fun ConversationApp() {


    val navController= rememberNavController()
    val viewModel=viewModel<MyViewModel>()
    val context= LocalContext.current
    NavHost(navController = navController, startDestination = "ConversationList"){
//        val jsonList = readJsonFile(context = context, viewModel.conversationType!!.fileName)

//        jsonList?.let {
//            viewModel.conversationDetails= parseJson(it)!!
//
//
//        }
        composable("ConversationList"){
            ConversationsListScreen(navController,viewModel)
        }
        composable("ConversationScreen"){
            val jsonString = readJsonFile(context = context, viewModel.conversationType!!.fileName)
            jsonString?.let {

                viewModel.conversationDetails= parseJson(it)
            }
            ConversationScreen(navController = navController,viewModel)
        }
    }








    
}