package com.github.kmachida12345.coroutinesplayground.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greeting(text: String) {

    var isSelected by remember {
        mutableStateOf(false)
    }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

    Text(text = "hello, $text!!",
        modifier = Modifier
            .background(color = backgroundColor)
        .clickable {
            isSelected = !isSelected
        })
    
}


@Preview
@Composable
fun PreviewGreeting() {
    Greeting("Android")
}
