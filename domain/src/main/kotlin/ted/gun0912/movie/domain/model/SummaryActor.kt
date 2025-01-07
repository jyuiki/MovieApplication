package ted.gun0912.movie.domain.model

data class SummaryActor(
    val id:Int,
    val name: String,
    val character: String,
    val popularity: Float,
    val profileImageUrl: String?,
    val profileDetailUrl: String,
)
