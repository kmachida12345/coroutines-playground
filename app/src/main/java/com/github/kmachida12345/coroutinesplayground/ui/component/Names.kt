package com.github.kmachida12345.coroutinesplayground.ui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.github.kmachida12345.coroutinesplayground.model.GithubRepo

@Composable
fun Names(list: List<String> = listOf("hoge", "fuga", "piyo"), modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier
    ) {
        items(list) { name ->
            Greeting(text = "$name san")
            Divider(color = Color.Black)
        }
    }
}
@Composable
fun Repos(list: List<GithubRepo>? = listOf(), modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier
    ) {
        if (list == null)
            return@LazyColumn
        items(list) { name ->
            Greeting(text = "${name.name} san")
            Divider(color = Color.Black)
        }
    }
}