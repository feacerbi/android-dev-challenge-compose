package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class LogInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    Background()

    ConstraintLayout(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        val (title, emailInput, passInput, button, signUp) = createRefs()

        createVerticalChain(
            title, emailInput, passInput, button, signUp,
            chainStyle = ChainStyle.Packed
        )

        Title(
            modifier = Modifier
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(emailInput.top)
                }
        )

        EmailInputField(
            modifier = Modifier
                .padding(top = 32.dp)
                .constrainAs(emailInput) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(passInput.top)
                }
        )

        PasswordInputField(
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(passInput) {
                    top.linkTo(emailInput.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(button.top)
                }
        )

        LogInButton(modifier = Modifier
            .padding(8.dp)
            .constrainAs(button) {
                top.linkTo(passInput.bottom)
                start.linkTo(passInput.start)
                end.linkTo(passInput.end)
                bottom.linkTo(signUp.top)
                width = Dimension.fillToConstraints
            }
        )

        Text(
            text = "Don't have an account? Sign up",
            modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(signUp) {
                    top.linkTo(button.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            style = typography.body1
        )
    }
}

@Composable
fun Background(darkTheme: Boolean = isSystemInDarkTheme()) {
    val backgroundResource = if (darkTheme) {
        R.drawable.login_background_dark
    } else {
        R.drawable.login_background_light
    }

    Image(
        painter = painterResource(id = backgroundResource),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun Title(modifier: Modifier) {
    Text(text = "LOG IN", modifier = modifier, style = typography.h1)
}

@Composable
fun EmailInputField(modifier: Modifier) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Email address") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        maxLines = 1,
        modifier = modifier
            .height(56.dp),
        textStyle = typography.body1
    )
}

@Composable
fun PasswordInputField(modifier: Modifier) {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        maxLines = 1,
        modifier = modifier
            .height(56.dp),
        textStyle = typography.body1
    )
}

@Composable
fun LogInButton(modifier: Modifier) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .height(72.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
    ) {
        Text(text = "LOG IN")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme(false) {
        LoginScreen()
    }
}