package ted.gun0912.movie.presentation.model

import ted.gun0912.movie.domain.model.Genre

data class GenreModel(
    val id: Int,
    val name: String,
)

fun Genre.toPresentation(): GenreModel = GenreModel(id, name)
