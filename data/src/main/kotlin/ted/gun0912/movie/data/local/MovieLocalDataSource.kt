package ted.gun0912.movie.data.local

import ted.gun0912.movie.data.model.MovieEntity

interface MovieLocalDataSource {

    suspend fun getMovie(movieId: Int): MovieEntity?

    suspend fun saveMovie(movie: MovieEntity)
}
