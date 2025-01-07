package ted.gun0912.movie.data.model

import ted.gun0912.movie.data.DataMapper
import ted.gun0912.movie.domain.model.SummaryActor

data class SummaryActorEntity(
    val id: Int,
    val name: String,
    val character: String,
    val popularity: Float,
    val profileImageUrl: String?,
    val profileDetailUrl: String,
) : DataMapper<SummaryActor> {
    override fun toDomain(): SummaryActor =
        SummaryActor(id, name, character, popularity, profileImageUrl, profileDetailUrl)
}
