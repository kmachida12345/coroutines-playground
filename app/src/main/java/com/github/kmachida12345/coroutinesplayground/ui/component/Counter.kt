package com.github.kmachida12345.coroutinesplayground.ui.component

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count % 2 == 0) Color.Green else Color.Red
        )) {
        Text(text = "I've been clicked $count times!")
    }

}