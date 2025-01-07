package ted.gun0912.movie.data.model

import ted.gun0912.movie.data.DataMapper
import ted.gun0912.movie.domain.model.Genre

data class GenreEntity(
    val id: Int,
    val name: String,
) : DataMapper<Genre> {
    override fun toDomain(): Genre =
        Genre(id, name)
}
