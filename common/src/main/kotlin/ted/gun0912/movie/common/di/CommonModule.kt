package ted.gun0912.movie.common.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ted.gun0912.movie.common.exception.ErrorHandlerImpl
import ted.gun0912.movie.component.ErrorHandler

import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
internal abstract class CommonModule {

    @Binds
    @Singleton
    abstract fun bindErrorHandler(errorHandler: ErrorHandlerImpl): ErrorHandler

}
