package ted.gun0912.movie.data.impl

import kotlinx.coroutines.flow.Flow
import ted.gun0912.movie.data.bound.flowDataResource
import ted.gun0912.movie.data.local.MovieLocalDataSource
import ted.gun0912.movie.data.remote.MovieRemoteDataSource
import ted.gun0912.movie.data_resource.DataResource
import ted.gun0912.movie.domain.model.SummaryActor
import ted.gun0912.movie.domain.model.Movie
import ted.gun0912.movie.domain.model.SummaryMovie
import ted.gun0912.movie.domain.repository.MovieRepository
import javax.inject.Inject

internal class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
) : MovieRepository {
    override fun getSummaryMovies(): Flow<DataResource<List<SummaryMovie>>> =
        flowDataResource { movieRemoteDataSource.getSummaryMovies() }

    override fun getMovie(movieId: Int): Flow<DataResource<Movie>> =
        flowDataResource(
            { movieRemoteDataSource.getMovie(movieId) },
            { movieLocalDataSource.getMovie(movieId) },
            { movieLocalDataSource.saveMovie(it) }
        )

    override fun getActors(movieId: Int): Flow<DataResource<List<SummaryActor>>> =
        flowDataResource { movieRemoteDataSource.getActors(movieId) }

    override fun getRecommendMovies(movieId: Int): Flow<DataResource<List<SummaryMovie>>> =
        flowDataResource { movieRemoteDataSource.getRecommendMovies(movieId) }

    override fun getSimilarMovies(movieId: Int): Flow<DataResource<List<SummaryMovie>>> =
        flowDataResource { movieRemoteDataSource.getSimilarMovies(movieId) }
}
