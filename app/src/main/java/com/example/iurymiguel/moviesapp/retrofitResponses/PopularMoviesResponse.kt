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
}

class PopularMovie {

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

    @SerializedName("production_companies")
    lateinit var productionCompanies: List<ProductionCompany>

    @SerializedName("production_countries")
    lateinit var productionCountries: List<ProductionCountry>

    @SerializedName("spoken_languages")
    lateinit var spokenLanguages: List<SpokenLanguage>
}

class ProductionCompany {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("logo_path")
    lateinit var logoPath: String

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("origin_country")
    lateinit var originCountry: String

}

class ProductionCountry {
    @SerializedName("iso_3166_1")
    lateinit var countryCode: String

    @SerializedName("name")
    lateinit var name: String
}

class SpokenLanguage {

    @SerializedName("iso_639_1")
    lateinit var languageCode: String

    @SerializedName("name")
    lateinit var name: String
}