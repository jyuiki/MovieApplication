package ted.gun0912.movie.local.impl

import ted.gun0912.movie.data.local.MovieLocalDataSource
import ted.gun0912.movie.data.model.MovieEntity
import ted.gun0912.movie.local.model.toLocal
import ted.gun0912.movie.local.room.dao.MovieDao
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
) : MovieLocalDataSource {
    override suspend fun getMovie(movieId: Int): MovieEntity? =
        movieDao.getMovie(movieId)?.toData()

    override suspend fun saveMovie(movie: MovieEntity) {
        movieDao.insert(movie.toLocal())
    }
}
