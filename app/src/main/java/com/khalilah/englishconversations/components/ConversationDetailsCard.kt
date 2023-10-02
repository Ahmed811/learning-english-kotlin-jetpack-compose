package com.khalilah.englishconversations.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khalilah.englishconversations.R
import com.khalilah.englishconversations.models.DialogueModel

@Composable
fun ConversationDetailsCard(dialogueModel: DialogueModel,onAudioClick:()->Unit={}) {

    if (dialogueModel.view=="right"){
        Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.fillMaxWidth().padding(5.dp,15.dp)) {
            Card(border = BorderStroke(2.dp, Color.Cyan), modifier = Modifier.fillMaxWidth(.9f),) {
                Column(Modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = dialogueModel.english, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth(),fontFamily = FontFamily(
                            Font(R.font.young_sanseirf)
                            ))
                    Spacer(modifier = Modifier.height(13.dp))
                    Icon(painter = painterResource(id = R.drawable.baseline_volume_up_24), contentDescription = "Play Audio",Modifier.size(30.dp).clickable {onAudioClick.invoke()  }, tint = Color.DarkGray)
                    Spacer(modifier = Modifier.height(13.dp))
                    Text(text = dialogueModel.arabic, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth(),fontFamily = FontFamily(
                            Font(R.font.honor)
                            ))

                }
            }

        }
    }else{
        Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.fillMaxWidth().padding(5.dp,15.dp)) {
            Card(border = BorderStroke(2.dp, Color.Cyan), modifier = Modifier.fillMaxWidth(.9f), colors = cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(green = .9f),
            ),) {
                Column(Modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = dialogueModel.english, textAlign = TextAlign.Start, modifier = Modifier.fillMaxWidth(),fontFamily = FontFamily(
                            Font(R.font.young_sanseirf)
                            ))
                    Spacer(modifier = Modifier.height(13.dp))
                    Icon(painter = painterResource(id = R.drawable.baseline_volume_up_24), contentDescription = "Play Audio",Modifier.size(30.dp).clickable {onAudioClick.invoke()  }, tint = Color.DarkGray)
                    Spacer(modifier = Modifier.height(13.dp))
                    Text(text = dialogueModel.arabic, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth(), fontFamily = FontFamily(
                        Font(R.font.honor)
                    ))

                }
            }

        }
    }


}





@Preview(showBackground = true)
@Composable
fun ConversationDetailsCardPreview() {
    ConversationDetailsCard(DialogueModel("person1","left","Hello,How Are You?!","مرحبا،كيف حالك؟!"))
}