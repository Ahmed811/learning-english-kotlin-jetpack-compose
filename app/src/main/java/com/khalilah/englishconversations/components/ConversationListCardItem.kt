package com.khalilah.englishconversations.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khalilah.englishconversations.models.ConversationsList
import com.khalilah.englishconversations.models.conversationsList

@Composable
fun ConversationListCardItem( conversationsList: ConversationsList,onCardClick:()->Unit={}) {


    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(horizontal = 5.dp, vertical = 10.dp).clickable {
        onCardClick.invoke()
        },

    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth() ) {

            Image(painterResource(id = conversationsList.img), contentDescription = "", modifier = Modifier.fillMaxWidth().size(80.dp).padding(5.dp))
            Spacer(modifier = Modifier.height(5.dp))
            Text(text =conversationsList.titleArabic, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold )
            Text(text =conversationsList.title, fontSize = 14.sp, overflow = TextOverflow.Ellipsis, maxLines = 1 )

        }

    }
}



@Preview(showBackground = true)
@Composable
fun ConversationListCardItemPreview() {
    ConversationListCardItem(conversationsList = conversationsList.first())
}





