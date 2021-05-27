package com.github.kmachida12345.coroutinesplayground.ui.main

import androidx.lifecycle.ViewModel
import com.github.kmachida12345.coroutinesplayground.model.GithubRepo
import com.github.kmachida12345.coroutinesplayground.model.GithubRepoRepository
import com.github.kmachida12345.coroutinesplayground.model.api.Resource
import kotlinx.coroutines.flow.Flow

class MainViewModel(private val repository: GithubRepoRepository) : ViewModel() {

    fun getRepos(userId: String): Flow<Resource<List<GithubRepo>>> {
        return repository.getRepos(userId)
    }

}