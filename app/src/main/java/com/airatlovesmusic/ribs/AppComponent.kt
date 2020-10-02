package com.airatlovesmusic.ribs

import com.airatlovesmusic.global.Logger
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@AppScope
@Component(
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(appActivity: AppActivity)
}

@Module
class AppModule {
    @Provides
    @AppScope
    fun provideLogger(): Logger = Logger()
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class AppScope