package com.airatlovesmusic.ribs

import com.airatlovesmusic.global.system.logger.LoggerModule
import dagger.Component
import javax.inject.Scope

@AppScope
@Component(
    modules = [LoggerModule::class]
)
interface AppComponent {
    fun inject(appActivity: AppActivity)
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class AppScope