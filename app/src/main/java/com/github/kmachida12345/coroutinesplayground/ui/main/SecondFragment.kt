package com.github.kmachida12345.coroutinesplayground.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.kmachida12345.coroutinesplayground.R
import com.github.kmachida12345.coroutinesplayground.ui.component.Counter
import com.github.kmachida12345.coroutinesplayground.ui.component.Greeting
import com.github.kmachida12345.coroutinesplayground.ui.component.Names
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.livedata.observeAsState
import com.github.kmachida12345.coroutinesplayground.model.GithubRepo
import com.github.kmachida12345.coroutinesplayground.ui.component.Repos


class SecondFragment : Fragment() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        lifecycleScope.launch {
            viewModel.getRepos("kmachida12345")
        }
        return ComposeView(requireContext()).apply {
            setContent {
                val counterState = remember { mutableStateOf(0) }
                val list by viewModel.repos.observeAsState()

                MaterialTheme {
                    val typography = MaterialTheme.typography
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.header),
                            contentDescription = "",
                            modifier = Modifier
                                .height(180.dp)
                                .fillMaxWidth()
                                .weight(1f)
                                .clip(shape = RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(Modifier.height(64.dp))

                        Text(text = """hello compose!
                            |ながーいながいテキストのサンプルです
                            |えee
                            |aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                            |a
                            |a
                        """.trimMargin(),
                            style = typography.h6,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 2
                        )
                        Greeting(text = "Android")
                        Names(modifier = Modifier.weight(1f), list = List(100) {
                            "hello android $it st"
                        })

                        Repos(modifier = Modifier.weight(1f), list = list)
                        Counter(count = counterState.value,
                            updateCount = {newCount -> counterState.value = newCount})
                    }
                }
            }
        }
    }
}