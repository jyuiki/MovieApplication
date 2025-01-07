package ted.gun0912.movie.local.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ted.gun0912.movie.data.local.MovieLocalDataSource
import ted.gun0912.movie.local.impl.MovieLocalDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class LocalDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindMovieLocalDataResource(source: MovieLocalDataSourceImpl): MovieLocalDataSource

}
