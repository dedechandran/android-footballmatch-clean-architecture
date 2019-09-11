package com.example.footballmatch.ui.league.detail

import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides

@Module
class LeagueDetailModule {
    @Provides
    fun provideFragmentManager(leagueDetailActivity: LeagueDetailActivity) : FragmentManager = leagueDetailActivity.supportFragmentManager

    @Provides
    fun provideLeagueDetailPresenter(leagueDetailPresenter: LeagueDetailPresenter) : LeagueDetailContract.Presenter = leagueDetailPresenter
}