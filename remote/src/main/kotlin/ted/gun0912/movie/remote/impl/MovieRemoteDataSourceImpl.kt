package ted.gun0912.movie.remote.impl

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import ted.gun0912.movie.component.Device
import ted.gun0912.movie.data.model.SummaryActorEntity
import ted.gun0912.movie.data.model.MovieEntity
import ted.gun0912.movie.data.model.SummaryMovieEntity
import ted.gun0912.movie.data.remote.MovieRemoteDataSource
import ted.gun0912.movie.remote.Constant.YOUTUBE_PREFIX_URL
import ted.gun0912.movie.remote.api.ApiService
import ted.gun0912.movie.remote.model.filterActor
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val device: Device,
) : MovieRemoteDataSource {

    private val language = device.language

    override suspend fun getSummaryMovies(): List<SummaryMovieEntity> =
        apiService.getSummaryMovies(language, device.country).summaryMovies.map { it.toData() }

    override suspend fun getMovie(movieId: Int): MovieEntity = coroutineScope {
        val movieDeferred = async { apiService.getMovie(movieId, language) }
        val videoUrlDeferred = async { getVideoUrl(movieId) }
        val movie = movieDeferred.await()
        val videoUrl = videoUrlDeferred.await()

        with(movie) {
            MovieEntity(
                id,
                name,
                description,
                posterImageUrl,
                backdropImageUrl,
                videoUrl,
                rating,
                rateCount,
                releasedAt,
                runtime,
                genres.map { it.toData() },
            )
        }

    }

    private suspend fun getVideoUrl(movieId: Int): String {
        val videos = apiService.getVideos(movieId, language).results
        return videos
            .filter {
                it.site == YOUTUBE && it.type == TRAILER
            }
            .map { YOUTUBE_PREFIX_URL + it.key }
            .firstOrNull() ?: ""
    }

    override suspend fun getActors(movieId: Int): List<SummaryActorEntity> =
        apiService.getActors(movieId, language)
            .cast
            .filterActor()
            .map { it.toData() }

    override suspend fun getRecommendMovies(movieId: Int): List<SummaryMovieEntity> =
        apiService.getRecommendMovies(movieId, language).summaryMovies.map { it.toData() }

    override suspend fun getSimilarMovies(movieId: Int): List<SummaryMovieEntity> =
        apiService.getSimilarMovies(movieId, language).summaryMovies.map { it.toData() }

    companion object {
        private const val YOUTUBE = "YouTube"
        private const val TRAILER = "Trailer"
    }
}
