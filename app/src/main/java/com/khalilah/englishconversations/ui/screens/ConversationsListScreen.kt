package com.khalilah.englishconversations.ui.screens

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.khalilah.englishconversations.AppInfo
import com.khalilah.englishconversations.AppInfo.openPlayStoreForReview
import com.khalilah.englishconversations.AppInfo.sendEmail
import com.khalilah.englishconversations.R
import com.khalilah.englishconversations.models.conversationsList
import com.khalilah.englishconversations.components.ConversationListCardItem
import com.khalilah.englishconversations.viewmodels.MyViewModel

@Composable
fun ConversationsListScreen(navController: NavController,viewModel: MyViewModel) {
    val context= LocalContext.current
Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
    AdmobBanner(Modifier)
    Spacer(modifier = Modifier.height(5.dp))

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
//        Icon(imageVector = Icons.Default.MailOutline, contentDescription ="send message to developer" , modifier = Modifier
//            .size(40.dp)
//            .background(color = MaterialTheme.colorScheme.surface).clickable{},)

    Image(painterResource(id = R.drawable.email), contentDescription = "send message to developer", contentScale = ContentScale.FillBounds, modifier = Modifier
        .size(40.dp)
        .clickable {
            sendEmail(context, AppInfo.developerMail, "Feedback", "Dear Developer,")

        })

              //  Spacer(modifier = Modifier.width(200.dp))
//        Icon(imageVector = Icons.Default.Star, contentDescription ="send message to developer" , modifier = Modifier
//            .size(40.dp)
//            .background(color = MaterialTheme.colorScheme.surface).clickable{})

            Image(painterResource(id = R.drawable.star), contentDescription = "rate the app", contentScale = ContentScale.FillBounds, modifier = Modifier
                .size(40.dp)
                .clickable {
                    openPlayStoreForReview(context.packageName, context = context)
                })



    }
    Spacer(modifier = Modifier.height(8.dp))
    Image(painterResource(id = R.drawable.logo), contentDescription = "", contentScale = ContentScale.FillBounds, modifier = Modifier

        .size(250.dp, 200.dp)
        .padding(20.dp))
    Spacer(modifier = Modifier.height(15.dp))
    Text(text = context.getString(R.string.app_name), style = MaterialTheme.typography.titleLarge,fontFamily = FontFamily(
        Font(R.font.honor)
    )
    )
    LazyVerticalGrid(columns = GridCells.Adaptive(170.dp), contentPadding = PaddingValues(5.dp)){
        items(conversationsList.size){it->
            ConversationListCardItem(conversationsList = conversationsList[it]){
                viewModel.conversationType= conversationsList[it]
                navController.navigate("ConversationScreen")
            }
            }

        }

    }

    BackHandler() {
        AppInfo.showRatingPrompt(context)
    }
}



//@Preview(showBackground = true)
//@Composable
//fun ConversationsListScreenPreview() {
//    ConversationsListScreen(rememberNavController())
//}




@Composable
fun AdmobBanner(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        factory = { context ->
            // on below line specifying ad view.
            AdView(context).apply {
                // on below line specifying ad size
                //adSize = AdSize.BANNER
                // on below line specifying ad unit id
                // currently added a test ad unit id.
                setAdSize(AdSize.BANNER)
                adUnitId = AppInfo.adBanner
                // calling load ad to load our ad.
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}
