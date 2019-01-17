package com.example.iurymiguel.moviesapp.dataSource

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import android.arch.paging.PageKeyedDataSource
import com.example.iurymiguel.moviesapp.retrofitResponses.PopularMovie

class MovieDataSourceFactory(private val movieDataSource: MovieDataSource) : DataSource.Factory<Int, PopularMovie>() {

    private val mMovieLiveDataSource: MutableLiveData<PageKeyedDataSource<Int, PopularMovie>> = MutableLiveData()


    override fun create(): DataSource<Int, PopularMovie> {
        mMovieLiveDataSource.postValue(movieDataSource)
        return movieDataSource
    }

    fun getMovieLiveDataSource() = mMovieLiveDataSource
}