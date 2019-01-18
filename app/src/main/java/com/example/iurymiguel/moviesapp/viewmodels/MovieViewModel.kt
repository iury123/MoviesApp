package com.example.iurymiguel.moviesapp.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.iurymiguel.moviesapp.dataSource.MovieDataSource
import com.example.iurymiguel.moviesapp.dataSource.MovieDataSourceFactory
import com.example.iurymiguel.moviesapp.retrofitResponses.PopularMovie

class MovieViewModel(private val movieDataSourceFactory: MovieDataSourceFactory) : ViewModel() {

    var moviesPagedList: LiveData<PagedList<PopularMovie>>

    init {
        val config: PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(MovieDataSource.PAGE_SIZE)
            .build()
        moviesPagedList = LivePagedListBuilder(movieDataSourceFactory, config).build()
    }
}