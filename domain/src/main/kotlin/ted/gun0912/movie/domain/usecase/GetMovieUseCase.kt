package ted.gun0912.movie.domain.usecase

import ted.gun0912.movie.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    operator fun invoke(movieId: Int) =
        movieRepository.getMovie(movieId)
}
