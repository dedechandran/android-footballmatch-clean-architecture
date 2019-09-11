package com.example.footballmatch.di

import com.example.footballmatch.ui.league.LeagueActivity
import com.example.footballmatch.ui.league.detail.LeagueDetailActivity
import com.example.footballmatch.ui.league.LeagueModule
import com.example.footballmatch.ui.league.detail.LeagueDetailFragmentModule
import com.example.footballmatch.ui.league.detail.LeagueDetailModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {
    @ContributesAndroidInjector(modules = [LeagueModule::class])
    abstract fun provideLeagueActivity(): LeagueActivity

    @ContributesAndroidInjector(
        modules = [LeagueDetailModule::class,
            LeagueDetailFragmentModule::class]
    )
    abstract fun provideLeagueDetailActivity(): LeagueDetailActivity
}