package com.example.movie.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movie.R
import com.example.movie.data.GenreVO
import com.example.movie.data.MovieVO
import com.example.movie.data.models.MovieModeImpl
import com.example.movie.data.models.MovieModel
import com.example.movie.utils.IMAGE_BASE_URL
import com.example.movie.viewpod.ActorListViewPod
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var mMovieModel: MovieModel

    companion object {

        private const val IE_MOVIE_DETAIL = "movie_id_for_detail"

        fun newIntent(context: Context, movieId: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(IE_MOVIE_DETAIL, movieId)
            return intent
        }
    }

    private lateinit var mvpActors: ActorListViewPod
    private lateinit var mvpCreators: ActorListViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        setUpMovieModel()

        setUpViewPods()
        setUpListener()

        getIntentData()
    }

    private fun setUpMovieModel() {
        mMovieModel = MovieModeImpl
    }

    private fun getIntentData() {
        requestDetail(intent.getIntExtra(IE_MOVIE_DETAIL, 0))
    }

    private fun requestDetail(id: Int) {
        mMovieModel.getMovieDetailById(
            movieId = id,
            onFailure = {
                showError(it)
            }, onSuccess = {
                bindData(it)
            }
        )
    }

    private fun bindData(movie: MovieVO?) {
        movie?.apply {
            Glide.with(this@MovieDetailActivity).load("$IMAGE_BASE_URL${posterPath}")
                .into(ivMovieDetailPoster)
            ctlDetail.title = title
            tvMovieName.text = title
            tvMovieDetailReleaseYear.text = releaseDate?.substring(0, 4)
            tvRating.text = voteAverage?.toString() ?: ""
            rbRating.rating = setRatingBaseOnFiveStar()
            tvNumVotes.text = "${voteCount?.toString()} VOTES"
            bindForGenres(
                movie,
                genres ?: listOf()
            )
            tvOverview.text = overview ?: ""
            tvOriginalTitle.text = title ?: ""
            tvType.text = getGenresAsCommaSeparatedString()
            tvProduction.text = getProductionCountriesAsCommaSeparatedString()
            tvPremiere.text = releaseDate ?: ""
            tvDescription.text = overview ?: ""
        }
    }

    private fun bindForGenres(movie: MovieVO, genres: List<GenreVO>) {
        val size = genres.size ?: 0
        if (size < 3) {
            tvThirdGenre.visibility = View.GONE
        } else if (size < 2) {
            tvThirdGenre.visibility = View.GONE
            tvSecondGenre.visibility = View.GONE
        } else {
            genres.getOrNull(0)?.let { genreVO ->
                tvFirstGenre.text = genreVO.name
            }
            genres.getOrNull(1)?.let { genreVO ->
                tvSecondGenre.text = genreVO.name
            }
            genres.getOrNull(2)?.let { genreVO ->
                tvThirdGenre.text = genreVO.name
            }
        }
    }

    private fun showError(text: String) {
        Snackbar.make(clMovieDetail, text, Snackbar.LENGTH_LONG).show()
    }

    private fun setUpListener() {
        btnBack.setOnClickListener { super.onBackPressed() }
    }

    private fun setUpViewPods() {
        mvpActors = vpActors as ActorListViewPod
        mvpActors.setUpViewPod(R.color.colorPrimary, getString(R.string.lbl_actors), "")

        mvpCreators = vpActorCreator as ActorListViewPod
        mvpCreators.setUpViewPod(
            R.color.colorPrimary,
            getString(R.string.lbl_creators),
            getString(R.string.lbl_more_creators)
        )
    }
}