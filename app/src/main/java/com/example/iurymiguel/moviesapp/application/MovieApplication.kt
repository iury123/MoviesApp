package com.example.iurymiguel.moviesapp.application

import android.app.Application
import com.example.iurymiguel.moviesapp.providers.RetrofitProvider
import org.koin.dsl.module.module

class MovieApplication: Application() {

    private val modules = module {
        single { RetrofitProvider() }
    }

    override fun onCreate() {
        super.onCreate()
    }
}