package ted.gun0912.movie.remote.model

import com.google.gson.annotations.SerializedName

data class VideoWrapperResponse(
    @SerializedName("results")
    val results: List<VideoResponse>
)
