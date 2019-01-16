package com.example.iurymiguel.moviesapp.retrofitCalls

import com.example.iurymiguel.moviesapp.retrofitResponses.PopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {
    @GET("/movie/popular")
    fun getPopularMovies(@Query("page") page: Int): Call<PopularMoviesResponse>
}