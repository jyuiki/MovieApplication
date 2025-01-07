package ted.gun0912.movie.remote

interface RemoteMapper<DataModel> {
    fun toData(): DataModel
}
