package ted.gun0912.movie.domain.usecase

import ted.gun0912.movie.domain.repository.MovieRepository
import javax.inject.Inject

class GetSummaryMovieListUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    operator fun invoke() =
        movieRepository.getSummaryMovies()
}
