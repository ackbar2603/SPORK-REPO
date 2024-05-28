package com.example.spork.presentation.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spork.data.DummyData
import com.example.spork.model.News
import com.example.spork.presentation.news.component.newsColumn
import com.example.spork.presentation.component.TopBar
import com.example.spork.navigation.Screen

@Composable
fun newsScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    berita: List<News> = DummyData.newsList,


){
    Scaffold (
        topBar = { TopBar(backButton = {null})}
    ){innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(innerPadding)
        ){
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ){
                items(berita, key = {it.id}){
                    newsColumn(news = it) { newsId ->
                        navController.navigate(Screen.NewsDetail.route + "/$newsId")
                    }
                }
            }
        }

    }
}

//items(berita, key = {it.id}){
//    newsColumn(news = it) { berita ->
//        navController.navigate(Screen.NewsDetail.route + "/mentorId")
//    }
//}