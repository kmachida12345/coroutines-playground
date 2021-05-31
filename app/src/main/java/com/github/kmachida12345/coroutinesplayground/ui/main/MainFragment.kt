package com.github.kmachida12345.coroutinesplayground.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
            viewModel.getRepos("kmachida12345")
        }


        val inflate = inflater.inflate(R.layout.main_fragment, container, false)
        inflate.findViewById<Button>(R.id.next_page).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment())
                .commitNow()
        }
        return inflate
    }
}