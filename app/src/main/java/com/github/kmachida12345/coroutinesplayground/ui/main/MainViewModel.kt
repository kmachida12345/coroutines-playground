package com.github.kmachida12345.coroutinesplayground.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.github.kmachida12345.coroutinesplayground.model.GithubRepoRepository
import com.github.kmachida12345.coroutinesplayground.model.db.RepoDatabase
import kotlinx.coroutines.flow.collect

class MainViewModel(private val repository: GithubRepoRepository, private val db: RepoDatabase) : ViewModel() {

    val repos = db.repoDao().getAll().asLiveData()

    suspend fun getRepos(userId: String) {
        db.repoDao().deleteAll()

        val repos = repository.getRepos(userId)
        repos.collect {
            it.data?.forEach {
                db.repoDao().insert(it)
            }
        }
    }

}