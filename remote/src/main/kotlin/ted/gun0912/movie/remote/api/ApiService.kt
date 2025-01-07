package ted.gun0912.movie.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ted.gun0912.movie.remote.model.CreditWrapperResponses
import ted.gun0912.movie.remote.model.MovieResponse
import ted.gun0912.movie.remote.model.SummaryMovieWrapperResponse
import ted.gun0912.movie.remote.model.VideoWrapperResponse

interface ApiService {
    @GET("discover/movie?&sort_by=popularity.desc")
    suspend fun getSummaryMovies(
        @Query("language") language: String,
        @Query("region") country: String,
    ): SummaryMovieWrapperResponse

    @GET("movie/{movieId}")
    suspend fun getMovie(
        @Path("movieId") movieId: Int,
        @Query("language") language: String,
    ): MovieResponse

    @GET("movie/{movieId}/videos")
    suspend fun getVideos(
        @Path("movieId") movieId: Int,
        @Query("language") language: String,
    ): VideoWrapperResponse

    @GET("movie/{movieId}/credits")
    suspend fun getActors(
        @Path("movieId") movieId: Int,
        @Query("language") language: String,
    ): CreditWrapperResponses

    @GET("movie/{movieId}/recommendations")
    suspend fun getRecommendMovies(
        @Path("movieId") movieId: Int,
        @Query("language") language: String,
    ): SummaryMovieWrapperResponse

    @GET("movie/{movieId}/similar")
    suspend fun getSimilarMovies(
        @Path("movieId") movieId: Int,
        @Query("language") language: String,
    ): SummaryMovieWrapperResponse

}
