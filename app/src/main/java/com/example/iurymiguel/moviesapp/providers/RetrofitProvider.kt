package com.example.iurymiguel.moviesapp.providers

import com.example.iurymiguel.moviesapp.utils.Utils
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    private val mClient = OkHttpClient.Builder()
        .addInterceptor(RetrofitInterceptor())
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Utils.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(mClient)
        .build()


    inner class RetrofitInterceptor : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()

            val builder = request.newBuilder()

            val url: HttpUrl = request.url().newBuilder()
                .addQueryParameter(Utils.API_KEY_QUERY, Utils.API_KEY)
                .addQueryParameter(Utils.LANGUAGE, Utils.PT_BR)
                .build()

            request = builder.url(url).build()

            val response = chain.proceed(request)
            return response
        }

    }
}