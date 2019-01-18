package com.example.iurymiguel.moviesapp.application

import android.app.Application
import com.example.iurymiguel.moviesapp.dataSource.MovieDataSource
import com.example.iurymiguel.moviesapp.dataSource.MovieDataSourceFactory
import com.example.iurymiguel.moviesapp.providers.EventsProvider
import com.example.iurymiguel.moviesapp.providers.RetrofitProvider
import com.example.iurymiguel.moviesapp.viewmodels.MovieViewModel
import com.example.iurymiguel.moviesapp.views.MoviesListAdapter
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class MovieApplication : Application() {

    private val modules = module {
        single { RetrofitProvider() }
        factory { MovieDataSource(get(),get()) }
        factory { MovieDataSourceFactory(get()) }
        single { MoviesListAdapter() }
        single { EventsProvider() }
        viewModel { MovieViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(modules))
    }
}