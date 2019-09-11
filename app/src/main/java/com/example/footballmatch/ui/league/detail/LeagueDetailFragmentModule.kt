package com.example.footballmatch.ui.league.detail

import com.example.footballmatch.ui.league.detail.matches.MatchesFragment
import com.example.footballmatch.ui.league.detail.matches.MatchesFragmentModule
import com.example.footballmatch.ui.league.detail.standings.StandingsFragment
import com.example.footballmatch.ui.league.detail.standings.StandingsFragmentModule
import com.example.footballmatch.ui.league.detail.teams.TeamsFragment
import com.example.footballmatch.ui.league.detail.teams.TeamsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LeagueDetailFragmentModule {
    @ContributesAndroidInjector(modules = [MatchesFragmentModule::class])
    abstract fun provideMatchesFragment(): MatchesFragment

    @ContributesAndroidInjector(modules = [StandingsFragmentModule::class])
    abstract fun provideStandingsFragment() : StandingsFragment

    @ContributesAndroidInjector(modules = [TeamsFragmentModule::class])
    abstract fun provideTeamsFragment() : TeamsFragment
}