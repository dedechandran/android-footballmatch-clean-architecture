package com.example.footballmatch.di

import com.example.data.ApiProvider
import com.example.data.league.LeagueRepositoryImpl
import com.example.data.league.datasource.remote.LeagueService
import com.example.domain.repository.LeagueRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideLeagueService(): LeagueService =
        ApiProvider().initRetrofit().create(LeagueService::class.java)

    @Provides
    fun provideLeagueRepository(leagueRepositoryImpl: LeagueRepositoryImpl): LeagueRepository =
        leagueRepositoryImpl
}