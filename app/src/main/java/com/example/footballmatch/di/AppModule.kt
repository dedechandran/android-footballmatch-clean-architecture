package com.example.footballmatch.di

import android.content.Context
import com.example.domain.PostExecutionThread
import com.example.footballmatch.AppCore
import com.example.footballmatch.UiThread
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideAppContext(appCore: AppCore): Context = appCore

    @Provides
    fun provideUiThread(uiThread: UiThread): PostExecutionThread = uiThread
}