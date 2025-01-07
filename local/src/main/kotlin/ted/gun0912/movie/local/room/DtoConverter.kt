package ted.gun0912.movie.local.room

import androidx.room.TypeConverter
import ted.gun0912.movie.common.extension.fromJson
import ted.gun0912.movie.common.extension.toJson
import ted.gun0912.movie.local.model.GenreLocal
import java.util.Date

class DtoConverter {

    @TypeConverter
    fun fromTimestamp(value: Long): Date = Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date): Long = date.time

    @TypeConverter
    fun fromGenres(genre: List<GenreLocal>) = genre.toJson()

    @TypeConverter
    fun toGenres(json: String) = json.fromJson<List<GenreLocal>>()

}
