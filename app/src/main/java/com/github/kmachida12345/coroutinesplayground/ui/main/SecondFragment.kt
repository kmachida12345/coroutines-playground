package com.github.kmachida12345.coroutinesplayground.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.github.kmachida12345.coroutinesplayground.R
import com.github.kmachida12345.coroutinesplayground.ui.component.Counter
import com.github.kmachida12345.coroutinesplayground.ui.component.Greeting
import com.github.kmachida12345.coroutinesplayground.ui.component.Names

class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val list = listOf<String>("hoge", "aafdjsakfl", "testdesu")


        return ComposeView(requireContext()).apply {
            setContent {
                val counterState = remember { mutableStateOf(0) }

                MaterialTheme {
                    val typography = MaterialTheme.typography
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.header),
                            contentDescription = "",
                            modifier = Modifier
                                .height(180.dp)
                                .fillMaxWidth()
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
                        Names(list = list)
                        Counter(count = counterState.value,
                            updateCount = {newCount -> counterState.value = newCount})
                    }
                }
            }
        }
    }
}