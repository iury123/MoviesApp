package com.example.iurymiguel.moviesapp.dataSource

import android.arch.paging.PageKeyedDataSource
import com.example.iurymiguel.moviesapp.providers.RetrofitProvider
import com.example.iurymiguel.moviesapp.retrofitResponses.PopularMovie
import com.example.iurymiguel.moviesapp.retrofitResponses.PopularMoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieDataSource(private val retrofitProvider: RetrofitProvider) :
    PageKeyedDataSource<Int, PopularMovie>() {

    companion object {
        const val FIRST_PAGE = 1
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PopularMovie>) {
        retrofitProvider.getMovieApi().getPopularMovies(FIRST_PAGE).enqueue(object : Callback<PopularMoviesResponse> {
            override fun onResponse(call: Call<PopularMoviesResponse>, response: Response<PopularMoviesResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.onResult(it.results, null, FIRST_PAGE + 1)
                    }
                }
            }

            override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {

            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PopularMovie>) {
        retrofitProvider.getMovieApi().getPopularMovies(params.key).enqueue(object : Callback<PopularMoviesResponse> {
            override fun onResponse(call: Call<PopularMoviesResponse>, response: Response<PopularMoviesResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        val key = if (params.key < it.totalPages) params.key + 1 else null
                        callback.onResult(it.results, key)
                    }
                }
            }

            override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {

            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PopularMovie>) {
        retrofitProvider.getMovieApi().getPopularMovies(params.key).enqueue(object : Callback<PopularMoviesResponse> {
            override fun onResponse(call: Call<PopularMoviesResponse>, response: Response<PopularMoviesResponse>) {
                val key = if (params.key > 1) params.key - 1 else null
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback.onResult(it.results, key)
                    }
                }
            }

            override fun onFailure(call: Call<PopularMoviesResponse>, t: Throwable) {

            }
        })
    }
}