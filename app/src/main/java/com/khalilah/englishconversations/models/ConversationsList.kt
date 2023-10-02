package com.khalilah.englishconversations.models

import com.khalilah.englishconversations.R

data class ConversationsList(val title:String,val titleArabic:String,val fileName:String,val img:Int)

val conversationsList= listOf<ConversationsList>(
    ConversationsList("Greetings and Introductions","تحيات وتقديمات","greeting.json", R.drawable.handshake),
    ConversationsList("At the Supermarket","في السوبر ماركت","supermarket.json", R.drawable.market),
    ConversationsList("At the Restaurant","في المطعم","resturant.json", R.drawable.cooking),
    ConversationsList("Travel and Transportation","السفر والمواصلات","transportation.json", R.drawable.transportation),
    ConversationsList("At the Airport","في المطار","airport.json", R.drawable.airport),
    ConversationsList("Making Plans","صنع الخطط","plans.json", R.drawable.strategy),
    ConversationsList("Asking for Directions","السؤال عن الاتجاهات","direction.json", R.drawable.directional),
    ConversationsList("At the Doctor's Office","في عيادة الطبيب","doctor.json", R.drawable.medical),
    ConversationsList("At the Bank","في البنك","bank.json", R.drawable.bank),
    ConversationsList("Shopping for Clothes","التسوق لشراء الملابس","clothes.json", R.drawable.clothes),
    ConversationsList("At the Library","في المكتبة","library.json", R.drawable.library),
    ConversationsList("Talking About the Weather","الحديث عن الطقس","weather.json", R.drawable.weather),
    ConversationsList("At the Gym","في النادي الرياضي","gym.json", R.drawable.gym),
    ConversationsList("At a Party","في الحفلة","party.json", R.drawable.party),
    ConversationsList("Talking About Hobbies","الحديث عن الهوايات","hobbies.json", R.drawable.hobbies),
    ConversationsList("At the Movie Theater","في دار السينما","movie.json", R.drawable.tv),
    ConversationsList("At the Hair Salon","في صالون الشعر","hairsalon.json", R.drawable.barbershop),
    ConversationsList("Emergencies","حالات الطواريء","Emergency.json", R.drawable.siren),

    )