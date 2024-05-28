package com.example.spork.presentation.news.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spork.R
import com.example.spork.model.News
import com.example.spork.ui.theme.SPORKTheme


@Composable
fun newsItem(
    news: News,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {onItemClicked(news.id)}
    ){
        Image(painter = painterResource(id = news.newsImageID),
            contentDescription = news.title, modifier = Modifier
                .clip(CircleShape)
                .size(12.dp)
        )
        Text(
            text = news.title,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun newsItemHorizontalPreview() {
    SPORKTheme {
        newsItem(
            news = News(1, "Monty",
                "this is the news"
                , "Monty enjoys chicken treats and cuddling while watching Seinfeld.", R.drawable.p1),
            onItemClicked = { newsId ->
                println("Mentor Id : $newsId")
            }
        )
    }
}

