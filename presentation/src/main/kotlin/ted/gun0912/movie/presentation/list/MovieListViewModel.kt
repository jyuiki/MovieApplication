package ted.gun0912.movie.presentation.list

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ted.gun0912.movie.data_resource.mapListDataResource
import ted.gun0912.movie.domain.usecase.GetSummaryMovieListUseCase
import ted.gun0912.movie.presentation.base.BaseViewModel
import ted.gun0912.movie.presentation.base.ViewEvent
import ted.gun0912.movie.presentation.list.MovieListViewModel.Event
import ted.gun0912.movie.presentation.model.SummaryMovieModel
import ted.gun0912.movie.presentation.model.toPresentation
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getSummaryMovieListUseCase: GetSummaryMovieListUseCase,
) : BaseViewModel<Event>() {

    private val _summaryMovies = MutableStateFlow<List<SummaryMovieModel>>(emptyList())
    val summaryMovies = _summaryMovies.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() = launch {
        getSummaryMovieListUseCase()
            .mapListDataResource { it.toPresentation() }
            .collectDataResource({
                _summaryMovies.value = it
            })
    }

    sealed class Event : ViewEvent

}
