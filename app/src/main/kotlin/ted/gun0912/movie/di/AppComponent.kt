package ted.gun0912.movie.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ted.gun0912.movie.MovieApplication
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(application: Application): String =
        (application as MovieApplication).baseUrl

}
