package com.example.androiddevchallenge

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun Favorites() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(text = "FAVORITE COLLECTIONS", style = typography.h2)

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .horizontalScroll(ScrollState(0), enabled = true),
        ) {
            Column {
                FavoriteIcon(resourceId = R.drawable.short_mantras, title = "Short mantras")
                Spacer(modifier = Modifier.height(8.dp))
                FavoriteIcon(resourceId = R.drawable.nature_meditations, title = "Nature meditations")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                FavoriteIcon(resourceId = R.drawable.stress_and_anxiety, title = "Stress and anxiety")
                Spacer(modifier = Modifier.height(8.dp))
                FavoriteIcon(resourceId = R.drawable.self_massage, title = "Self-massage")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                FavoriteIcon(resourceId = R.drawable.short_mantras, title = "Short mantras")
                Spacer(modifier = Modifier.height(8.dp))
                FavoriteIcon(resourceId = R.drawable.nightly_wind_down, title = "Nightly wind down")
            }
        }
    }
}

@Composable
fun FavoriteIcon(@DrawableRes resourceId: Int, title: String) {
    Row(
        modifier = Modifier
            .width(192.dp)
            .height(56.dp)
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = null,
            modifier = Modifier
                .width(56.dp)
                .height(56.dp),
            contentScale = ContentScale.Crop
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = title,
                style = typography.h3,
                maxLines = 2,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    MyTheme(false) {
        Favorites()
    }
}