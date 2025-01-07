package ted.gun0912.movie.presentation.detail

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ted.gun0912.movie.component.Device
import ted.gun0912.movie.data_resource.mapDataResource
import ted.gun0912.movie.data_resource.mapListDataResource
import ted.gun0912.movie.domain.usecase.GetActorListUseCase
import ted.gun0912.movie.domain.usecase.GetMovieUseCase
import ted.gun0912.movie.domain.usecase.GetRecommendMovieListUseCase
import ted.gun0912.movie.domain.usecase.GetSimilarMovieListUseCase
import ted.gun0912.movie.presentation.base.BaseViewModel
import ted.gun0912.movie.presentation.base.ViewEvent
import ted.gun0912.movie.presentation.detail.MovieDetailViewModel.Event
import ted.gun0912.movie.presentation.model.SummaryActorModel
import ted.gun0912.movie.presentation.model.MovieModel
import ted.gun0912.movie.presentation.model.SummaryMovieModel
import ted.gun0912.movie.presentation.model.toPresentation
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val device: Device,
    private val getMovieUseCase: GetMovieUseCase,
    private val getActorListUseCase: GetActorListUseCase,
    private val getRecommendMovieListUseCase: GetRecommendMovieListUseCase,
    private val getSimilarMovieListUseCase: GetSimilarMovieListUseCase,
) : BaseViewModel<Event>() {

    private val _movie = MutableStateFlow<MovieModel?>(null)
    val movie = _movie.asStateFlow()

    private val _actors = MutableStateFlow<List<SummaryActorModel>>(emptyList())
    val actors = _actors.asStateFlow()

    private val _recommendMovies = MutableStateFlow<List<SummaryMovieModel>>(emptyList())
    val recommendMovies = _recommendMovies.asStateFlow()

    private val _similarMovies = MutableStateFlow<List<SummaryMovieModel>>(emptyList())
    val similarMovies = _similarMovies.asStateFlow()

    fun fetchMovie(movieId: Int) {
        launch {
            _movie.value = getMovieUseCase(movieId)
                .mapDataResource { it.toPresentation() }
                .await() ?: return@launch
        }
        launch {
            _actors.value = getActorListUseCase(movieId)
                .mapListDataResource { it.toPresentation() }
                .await() ?: return@launch
        }
        launch {
            _recommendMovies.value = getRecommendMovieListUseCase(movieId)
                .mapListDataResource { it.toPresentation() }
                .await() ?: return@launch
        }
        launch {
            _similarMovies.value = getSimilarMovieListUseCase(movieId)
                .mapListDataResource { it.toPresentation() }
                .await() ?: return@launch
        }
    }

    fun showVideo() {
        val videoUrl = movie.value?.videoUrl ?: return
        if (videoUrl.isNotBlank()) {
            device.showWebUrl(videoUrl)
        }
    }

    sealed class Event : ViewEvent {

    }
}
