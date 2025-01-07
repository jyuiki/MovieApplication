package ted.gun0912.movie.remote.model

import com.google.gson.annotations.SerializedName
import ted.gun0912.movie.data.model.SummaryMovieEntity
import ted.gun0912.movie.remote.Constant
import ted.gun0912.movie.remote.RemoteMapper
import java.util.Date

data class SummaryMovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val name: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("poster_path")
    val posterImagePath: String,
    @SerializedName("vote_average")
    val rating: Float,
    @SerializedName("vote_count")
    val rateCount: Int,
    @SerializedName("release_date")
    val releasedAt: Date,
) : RemoteMapper<SummaryMovieEntity> {

    private val posterImageUrl: String
        get() = Constant.POSTER_IMAGE_PREFIX_URL + posterImagePath

    override fun toData(): SummaryMovieEntity =
        SummaryMovieEntity(id, name, description, posterImageUrl, rating, rateCount, releasedAt)

}
