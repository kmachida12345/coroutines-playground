package com.github.kmachida12345.coroutinesplayground.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Names(list: List<String>) {
    Column {
        for (name in list) {
            Text(text = "name ha $name desu")
            Divider(color = Color.Black)

        }
    }
}