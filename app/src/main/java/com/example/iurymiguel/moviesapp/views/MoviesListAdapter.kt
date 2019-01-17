package com.example.iurymiguel.moviesapp.views

import android.arch.paging.PagedListAdapter
import android.databinding.BindingAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.iurymiguel.moviesapp.databinding.MovieItemListBinding
import com.example.iurymiguel.moviesapp.retrofitResponses.PopularMovie
import com.bumptech.glide.Glide


class MoviesListAdapter : PagedListAdapter<PopularMovie, MoviesListAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieItemListBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie!!)
    }


    inner class ViewHolder(private val binding: MovieItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: PopularMovie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }


    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<PopularMovie>() {
            override fun areItemsTheSame(oldItem: PopularMovie?, newItem: PopularMovie?) = oldItem?.id == newItem?.id

            override fun areContentsTheSame(oldItem: PopularMovie?, newItem: PopularMovie?) = oldItem == newItem
        }

        @JvmStatic
        @BindingAdapter("android:src")
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }
}