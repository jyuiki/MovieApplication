package ted.gun0912.movie.remote.model

import com.google.gson.annotations.SerializedName
import ted.gun0912.movie.data.model.GenreEntity
import ted.gun0912.movie.remote.RemoteMapper

data class GenreResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
) : RemoteMapper<GenreEntity> {
    override fun toData(): GenreEntity =
        GenreEntity(id, name)
}
