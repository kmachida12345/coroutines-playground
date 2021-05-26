package com.github.kmachida12345.coroutinesplayground

import android.app.Application
import com.github.kmachida12345.coroutinesplayground.model.GithubRepoRepositoryImpl
import com.github.kmachida12345.coroutinesplayground.model.api.GithubApi
import com.github.kmachida12345.coroutinesplayground.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin

import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {
    private val module: Module = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        single {
            get<Retrofit>().create(GithubApi::class.java)
        }

        single { GithubRepoRepositoryImpl(get()) }

        viewModel { MainViewModel(get<GithubRepoRepositoryImpl>()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(module))
        }
    }
}