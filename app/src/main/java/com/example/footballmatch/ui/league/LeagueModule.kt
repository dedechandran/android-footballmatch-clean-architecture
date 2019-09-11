package com.example.footballmatch.ui.league

import dagger.Module
import dagger.Provides

@Module
class LeagueModule {
    @Provides
    fun provideMainPresenter(leaguePresenter: LeaguePresenter) : LeagueContract.Presenter = leaguePresenter
}