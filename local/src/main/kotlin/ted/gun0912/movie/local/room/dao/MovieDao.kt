package ted.gun0912.movie.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import ted.gun0912.movie.local.model.MovieLocal
import ted.gun0912.movie.local.room.RoomConstant

@Dao
interface MovieDao : BaseDao<MovieLocal> {

    @Query("SELECT * FROM ${RoomConstant.Table.MOVIE} WHERE id = :movieId")
    suspend fun getMovie(movieId: Int): MovieLocal?
}
