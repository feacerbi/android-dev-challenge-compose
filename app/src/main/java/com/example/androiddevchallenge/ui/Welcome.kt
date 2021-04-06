package com.example.androiddevchallenge.ui

import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.LogInActivity
import com.example.androiddevchallenge.LoginScreen
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun Welcome() {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundImage()
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Header()
                Spacer(modifier = Modifier.padding(top = 24.dp))
                Button(
                    textId = R.string.button_sing_up,
                    backgroundColor = MaterialTheme.colors.primary
                )
                Button(
                    textId = R.string.button_log_in,
                    backgroundColor = MaterialTheme.colors.secondary,
                    onClick = {
                        context.apply {
                            startActivity(Intent(this, LogInActivity::class.java))
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun BackgroundImage(darkTheme: Boolean = isSystemInDarkTheme()) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(
                id = if (darkTheme) {
                    R.drawable.ic_light_welcome
                } else {
                    R.drawable.ic_light_welcome
                }
            ),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun Header() {
    Row(horizontalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.welcome_header),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = typography.h1
        )
    }
}

@Composable
fun Button(
    backgroundColor: Color,
    @StringRes textId: Int,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp, end = 8.dp)
            .height(72.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor)
    ) {
        Text(text = stringResource(id = textId))
    }
}

@Preview
@Composable
fun WelcomePreview() {
    MyTheme {
        Welcome()
    }
}