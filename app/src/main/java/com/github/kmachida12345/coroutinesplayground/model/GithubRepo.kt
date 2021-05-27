package com.github.kmachida12345.coroutinesplayground.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repo")
data class GithubRepo(
    @PrimaryKey
    val name: String = ""
) {
}
