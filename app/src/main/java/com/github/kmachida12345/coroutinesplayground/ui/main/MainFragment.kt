package com.github.kmachida12345.coroutinesplayground.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.github.kmachida12345.coroutinesplayground.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        lifecycleScope.launch {
            val flow = viewModel.getRepos("kmachida12345")
            flow.collect {
                Log.d("hoge", "onCreateView: hoge$it")
            }
            Log.d("hoge", "onCreateView: flow=${flow}")
        }

        return inflater.inflate(R.layout.main_fragment, container, false)
    }
}