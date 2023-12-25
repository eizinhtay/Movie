//package com.example.movie.network.dataAgent
//
//import android.os.AsyncTask
//import android.util.Log
//import com.example.movie.data.GenreVO
//import com.example.movie.data.MovieVO
//import com.example.movie.network.response.MovieListResponse
//import com.example.movie.utils.API_KEY
//import com.example.movie.utils.BASE_URL
//import com.example.movie.utils.GET_NOW_PLAYING
//import com.google.gson.Gson
//import java.io.BufferedReader
//import java.io.IOException
//import java.io.InputStreamReader
//import java.net.HttpURLConnection
//import java.net.URL
//
//class MovieDataAgentImpl:MovieDataAgent {
//    fun getNowPlayMovie() {
//        //networkCall
//        GetNowPlayingTasking().execute()
//
//    }
//
//    class GetNowPlayingTasking : AsyncTask<Unit, Unit, MovieListResponse?>() {
//
//        @Deprecated("Deprecated in Java")
//        override fun doInBackground(vararg p0: Unit?): MovieListResponse? {
//            val url: URL
//            var reader: BufferedReader? = null
//            val stringBuilder: StringBuilder
//
//            try {
//                url =
//                    URL("""${BASE_URL}${GET_NOW_PLAYING}?api_key=${API_KEY}&language=en-US&page=1""")
//                val connection = url.openConnection() as HttpURLConnection
//
//                connection.requestMethod = "GET"
//
//                connection.doInput = true
//                connection.doOutput = false
//
//                connection.readTimeout = 15 * 1000
//
//                connection.connect()
//
//                reader = BufferedReader(
//                    InputStreamReader(connection.inputStream)
//                )
//                stringBuilder = StringBuilder()
//                for (line in reader.readLines()) {
//                    stringBuilder.append(line + "\n")
//                }
//                val respondString = stringBuilder.toString()
//                Log.d("NowPlayingMovies", respondString)
//
//                val response = Gson().fromJson(respondString, MovieListResponse::class.java)
//                return response
//            } catch (e: Exception) {
//                e.printStackTrace()
//                Log.d("NowPlayingErr", e.message ?: "")
//            } finally {
//                if (reader != null) {
//                    try {
//                        reader.close()
//                    } catch (io: IOException) {
//                        io.printStackTrace()
//                    }
//                }
//            }
//            return null
//        }
//
//        override fun onPostExecute(result: MovieListResponse?) {
//            super.onPostExecute(result)
//        }
//    }
//
//    override fun getNowPlayMovies(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
//
//    }
//
//    override fun getPopularMovies(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {
//
//    }
//
//    override fun getTopRatedMovies(
//        onSuccess: (List<MovieVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//    }
//
//    override fun getGenres(onSuccess: (List<GenreVO>) -> Unit, onFailure: (String) -> Unit) {
//
//    }
//
//    override fun getMoviesByGenre(
//        genreId: String,
//        onSuccess: (List<MovieVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//    }
//}