package com.github.kmachida12345.coroutinesplayground.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.github.kmachida12345.coroutinesplayground.model.GithubRepo
import kotlinx.coroutines.flow.Flow

@Dao
interface RepoDao {
    @Insert
    suspend fun insert(repo: GithubRepo): Long

    @Query("delete from repo")
    suspend fun deleteAll()

    @Query("select * from repo")
    fun getAll(): Flow<List<GithubRepo>>

}
