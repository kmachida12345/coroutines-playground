package com.github.kmachida12345.coroutinesplayground.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.kmachida12345.coroutinesplayground.model.GithubRepo


@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
abstract class RepoDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao

}