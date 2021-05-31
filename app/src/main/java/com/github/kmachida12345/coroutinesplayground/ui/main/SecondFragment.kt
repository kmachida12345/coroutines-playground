package com.github.kmachida12345.coroutinesplayground.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

class SecondFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return ComposeView(requireContext()).apply {
            setContent {
                Text(text = "hello compose!")
            }
        }
    }
}