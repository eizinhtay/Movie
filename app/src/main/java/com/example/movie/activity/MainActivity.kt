package com.example.movie.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.adapters.BannerAdapter
import com.example.movie.adapters.ShowCaseAdapter
import com.example.movie.data.GenreVO
import com.example.movie.data.models.MovieModeImpl
import com.example.movie.data.models.MovieModel
import com.example.movie.delegate.BannerViewHolderDelegate
import com.example.movie.delegate.MovieListViewHolderDelegate
import com.example.movie.viewpod.MovieListViewPod
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), MovieListViewHolderDelegate, BannerViewHolderDelegate {
    private lateinit var mBannerAdapter: BannerAdapter
    lateinit var showCaseAdapter: ShowCaseAdapter
    private lateinit var mMovieListViewPod: MovieListViewPod
    private lateinit var mMovieListByGenreViewPod: MovieListViewPod
    private val movieModel: MovieModel = MovieModeImpl
    private var mGenres: List<GenreVO> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //No Network Call //AsyncNetworkCall
        runOnUiThread{
            GlobalScope.launch {
                delay(3000)

            }
        }


        setUpViewPods()
        setUpBannerViewPager()
        setUpListener()
        setUpShowCaseRecyclerView()
        requestData()

    }

    private fun setUpViewPods() {
        mMovieListViewPod = viewPodMovieList as MovieListViewPod
        mMovieListViewPod.setUpMovieListViewPod(this)


        mMovieListByGenreViewPod = vpMovieByGenre as MovieListViewPod

    }

    private fun requestData() {
        movieModel.getNowPlayingMovies(onSuccess = {
            mBannerAdapter.setNewData(it)
        },
            onFailure = {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })

        movieModel.getPopularMovies(onSuccess = {
            mMovieListViewPod.setNewData(it)
        },
            onFailure = {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })

        movieModel.getTopRatedMovies(onSuccess = {
            showCaseAdapter.setNewData(it)
        },
            onFailure = {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })

        movieModel.getGenres(onSuccess = {
            mGenres = it
            setUpGenreTabLayout(it)

            it.firstOrNull()?.id?.let { genreId ->
                getMoviesByGenre(genreId)
            }

        },
            onFailure = {

            })
    }

    private fun getMoviesByGenre(genreId: Int) {
        movieModel.getMoviesByGenre(genreId = genreId, onSuccess = {
            mMovieListByGenreViewPod.setNewData(it)
        }
        ) {
            showError()

        }

    }

    private fun showError() {

    }

    private fun setUpShowCaseRecyclerView() {
        showCaseAdapter = ShowCaseAdapter()
        rvShowCases.apply {
            adapter = showCaseAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }

    }

    private fun setUpListener() {
        //Genre Tab Layout
        tabLayoutGenre.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    mGenres.getOrNull(tab.position)?.let { genreVO ->
                        getMoviesByGenre(genreVO.id)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun setUpGenreTabLayout(genreVOS: List<GenreVO>) {
        genreVOS.forEach { genre ->
            tabLayoutGenre.newTab().apply {
                text = genre.name
                tabLayoutGenre.addTab(this)
            }
        }

    }

    private fun setUpBannerViewPager() {
        mBannerAdapter = BannerAdapter(this)
        viewPagerBanner.adapter = mBannerAdapter

        dotIndicatorBanner.attachTo(viewPagerBanner)

    }

    override fun onMovieItemClick(movieId: Int) {
        startActivity(MovieDetailActivity.newIntent(this, movieId))

    }

    override fun onStart() {
        super.onStart()
        setUpViewPods()
    }

    override fun onItemClick(movieId: Int) {
        startActivity(MovieDetailActivity.newIntent(this, movieId))

    }
}