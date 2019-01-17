package com.example.iurymiguel.moviesapp.views

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iurymiguel.moviesapp.R
import com.example.iurymiguel.moviesapp.databinding.FragmentMovieListBinding
import com.example.iurymiguel.moviesapp.viewmodels.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MovieListFragment : Fragment() {

    private lateinit var mBinding: FragmentMovieListBinding
    private val mViewModel: MovieViewModel by viewModel()
    private val mAdapter: MoviesListAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel.moviesPagedList.observe(this, Observer {
            mAdapter.submitList(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)

        val recyclerView = mBinding.moviesRecyclerView
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        return mBinding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = MovieListFragment()
    }
}
