package com.github.kmachida12345.coroutinesplayground.model

import android.util.Log
import com.github.kmachida12345.coroutinesplayground.model.api.GithubApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface GithubRepoRepository {
    fun getRepos(userId: String): Flow<List<GithubRepo>?>
}

class GithubRepoRepositoryImpl(private val service: GithubApi): GithubRepoRepository{
    override fun getRepos(userId: String): Flow<List<GithubRepo>?> {
        return flow {
            try {
                emit(service.listRepos(userId))
            } catch (e: Exception) {
                Log.e("UserRepository", "getUser error", e)
            }
        }.flowOn(Dispatchers.IO)
    }
}