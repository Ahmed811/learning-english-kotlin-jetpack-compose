package com.khalilah.englishconversations.viewmodels

import androidx.lifecycle.ViewModel
import com.khalilah.englishconversations.models.ConversationModel
import com.khalilah.englishconversations.models.ConversationsList
import com.khalilah.englishconversations.models.DialogueModel

class MyViewModel:ViewModel() {

    var conversationType:ConversationsList?=null
     var conversationDetails:ConversationModel?=null
}