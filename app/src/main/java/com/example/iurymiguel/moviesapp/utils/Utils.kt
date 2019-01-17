package com.example.iurymiguel.moviesapp.utils

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException

class Utils private constructor() {
    companion object {
        const val API_KEY_QUERY = "api_key"
        const val API_KEY = "8ae076949ae08aae78e56a72c7a11c0d"
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val POSTER_PATH_BASE_URL = " http://image.tmdb.org/t/p/w185/"
        const val LANGUAGE = "language"
        const val PT_BR = "pt-BR"

        fun <T> deserializer(retrofit: Retrofit, responseBody: ResponseBody, pojoClass: Class<T>): T? {
            val converter: Converter<ResponseBody, T> = retrofit.responseBodyConverter(
                pojoClass, arrayOf()
            )
            try {
                return converter.convert(responseBody)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return null
        }
    }
}