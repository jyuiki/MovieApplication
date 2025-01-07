package ted.gun0912.movie.remote.api

import android.content.Context
import ted.gun0912.movie.common.extension.fromJson
import ted.gun0912.movie.remote.model.CreditWrapperResponses
import ted.gun0912.movie.remote.model.MovieResponse
import ted.gun0912.movie.remote.model.SummaryMovieWrapperResponse
import ted.gun0912.movie.remote.model.VideoWrapperResponse

class FakeApiService(private val context: Context) : ApiService {
    override suspend fun getSummaryMovies(
        language: String,
        country: String
    ): SummaryMovieWrapperResponse =
        getResponse("movies.json")

    override suspend fun getMovie(movieId: Int, language: String): MovieResponse =
        getResponse("movie.json")

    override suspend fun getVideos(movieId: Int, language: String): VideoWrapperResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getActors(movieId: Int, language: String): CreditWrapperResponses {
        TODO("Not yet implemented")
    }

    override suspend fun getRecommendMovies(
        movieId: Int,
        language: String
    ): SummaryMovieWrapperResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getSimilarMovies(
        movieId: Int,
        language: String
    ): SummaryMovieWrapperResponse {
        TODO("Not yet implemented")
    }

    private inline fun <reified T> getResponse(fileName: String): T {
        context.assets.open(fileName).use { inputStream ->
            val size: Int = inputStream.available()
            val buffer = ByteArray(size).apply {
                inputStream.read(this)
            }
            return String(buffer).fromJson<T>()!!
        }
    }
}
