package com.example.iurymiguel.moviesapp.providers

import android.arch.paging.PagedList
import com.example.iurymiguel.moviesapp.retrofitResponses.PopularMovie

class EventsProvider {

    private lateinit var mOnInitialLoadCompletedCallback: (List<PopularMovie>?) -> Unit

    fun onInitialLoadCompleted(callback: (List<PopularMovie>?) -> Unit) {
        mOnInitialLoadCompletedCallback = callback
    }

    fun publishInitialLoad(list: List<PopularMovie>?) {
        mOnInitialLoadCompletedCallback.let {
            it(list)
        }
    }


}