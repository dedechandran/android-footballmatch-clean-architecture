package com.example.footballmatch.di

import com.example.footballmatch.AppCore
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(AndroidSupportInjectionModule::class),
        (AppModule::class),
        (DataModule::class),
        (ActivitiesModule::class)]
)
interface AppComponent : AndroidInjector<AppCore> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<AppCore>()
}