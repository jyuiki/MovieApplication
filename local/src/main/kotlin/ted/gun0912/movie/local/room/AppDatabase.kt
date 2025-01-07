package ted.gun0912.movie.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ted.gun0912.movie.local.model.MovieLocal
import ted.gun0912.movie.local.room.dao.MovieDao

@Database(
    entities = [MovieLocal::class],
    version = RoomConstant.ROOM_VERSION
)

@TypeConverters(
    DtoConverter::class
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}
