package com.github.kmachida12345.coroutinesplayground.model

import com.github.kmachida12345.coroutinesplayground.model.api.GithubApi
import com.github.kmachida12345.coroutinesplayground.model.api.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import retrofit2.Response

interface GithubRepoRepository {
    fun getRepos(userId: String): Flow<Resource<List<GithubRepo>>>
}

class GithubRepoRepositoryImpl(private val service: GithubApi): GithubRepoRepository{

    override fun getRepos(userId: String): Flow<Resource<List<GithubRepo>>> = apiFlow { service.listRepos(userId) }

    private inline fun <reified T : Any> apiFlow(crossinline call: suspend () -> Response<T>): Flow<Resource<T>> =
        flow<Resource<T>> {
            val response = call()
            if (response.isSuccessful) emit(Resource.Success(data = response.body()!!))
            else throw HttpException(response)
        }.catch { it: Throwable ->
            emit(Resource.Error(it))
        }.onStart {
            emit(Resource.Loading)
        }.flowOn(Dispatchers.IO)

}