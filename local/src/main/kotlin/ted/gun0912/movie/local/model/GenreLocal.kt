package ted.gun0912.movie.local.model

import ted.gun0912.movie.data.model.GenreEntity
import ted.gun0912.movie.local.LocalMapper

data class GenreLocal(
    val id: Int,
    val name: String,
) : LocalMapper<GenreEntity> {
    override fun toData(): GenreEntity =
        GenreEntity(id, name)
}

fun GenreEntity.toLocal(): GenreLocal =
    GenreLocal(id, name)
