package com.example.iurymiguel.moviesapp.retrofitResponses

import com.example.iurymiguel.moviesapp.utils.Utils
import com.google.gson.annotations.SerializedName

class PopularMoviesResponse {

    @SerializedName("page")
    var page: Int = 1

    @SerializedName("total_results")
    var totalResults: Int = 0

    @SerializedName("total_pages")
    var totalPages: Int = 0

    @SerializedName("results")
    lateinit var results: List<PopularMovie>


    inner class PopularMovie {

        @SerializedName("id")
        val id: Int = 0

        @SerializedName("title")
        lateinit var title: String

        @SerializedName("original_title")
        lateinit var originalTitle: String

        @SerializedName("original_language")
        lateinit var originalLanguage: String

        @SerializedName("vote_average")
        var voteAverage: Double = 0.0

        @SerializedName("overview")
        lateinit var overview: String

        @SerializedName("release_date")
        lateinit var releaseDate: String

        @SerializedName("poster_path")
        var posterPath: String = Utils.POSTER_PATH_BASE_URL
    }

}