package ted.gun0912.movie.device.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ted.gun0912.movie.component.Haptic
import ted.gun0912.movie.device.impl.DeviceImpl
import ted.gun0912.movie.device.impl.HapticImpl
import ted.gun0912.movie.device.impl.ToasterImpl
import ted.gun0912.movie.component.Device
import ted.gun0912.movie.component.Toaster
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DeviceModule {

    @Binds
    @Singleton
    abstract fun bindDevice(device: DeviceImpl): Device

    @Binds
    @Singleton
    abstract fun bindToaster(toaster: ToasterImpl): Toaster

    @Binds
    @Singleton
    abstract fun bindHaptic(haptic: HapticImpl): Haptic
}
