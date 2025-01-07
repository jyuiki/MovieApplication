package ted.gun0912.movie.domain.repository

import kotlinx.coroutines.flow.Flow
import ted.gun0912.movie.data_resource.DataResource
import ted.gun0912.movie.domain.model.SummaryActor
import ted.gun0912.movie.domain.model.Movie
import ted.gun0912.movie.domain.model.SummaryMovie

interface MovieRepository {

    fun getSummaryMovies(): Flow<DataResource<List<SummaryMovie>>>

    fun getMovie(movieId: Int): Flow<DataResource<Movie>>

    fun getActors(movieId: Int): Flow<DataResource<List<SummaryActor>>>

    fun getRecommendMovies(movieId: Int): Flow<DataResource<List<SummaryMovie>>>

    fun getSimilarMovies(movieId: Int): Flow<DataResource<List<SummaryMovie>>>
}
