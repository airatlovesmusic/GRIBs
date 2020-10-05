package com.airatlovesmusic.global.system.logger

import dagger.Module
import dagger.Provides

@Module
class LoggerModule {
    @Provides
    fun provideLogger(): Logger = Logger()
}