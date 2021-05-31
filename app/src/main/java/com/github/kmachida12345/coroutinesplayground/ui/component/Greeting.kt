package com.github.kmachida12345.coroutinesplayground.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greeting(text: String) {
    Text(text = "hello, $text!!")
    
}


@Preview
@Composable
fun PreviewGreeting() {
    Greeting("Android")
}
