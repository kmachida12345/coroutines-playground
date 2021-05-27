package com.github.kmachida12345.coroutinesplayground.model.api

import com.github.kmachida12345.coroutinesplayground.model.GithubRepo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("/users/{user}/repos")
    suspend fun listRepos(@Path("user") user: String?): Response<List<GithubRepo>>

}
