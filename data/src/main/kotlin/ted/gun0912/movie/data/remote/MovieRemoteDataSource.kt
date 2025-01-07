package ted.gun0912.movie.data.remote

import ted.gun0912.movie.data.model.SummaryActorEntity
import ted.gun0912.movie.data.model.MovieEntity
import ted.gun0912.movie.data.model.SummaryMovieEntity

interface MovieRemoteDataSource {

    suspend fun getSummaryMovies(): List<SummaryMovieEntity>

    suspend fun getMovie(movieId: Int): MovieEntity

    suspend fun getActors(movieId: Int): List<SummaryActorEntity>

    suspend fun getRecommendMovies(movieId: Int): List<SummaryMovieEntity>

    suspend fun getSimilarMovies(movieId: Int): List<SummaryMovieEntity>
}
