package com.example.data.league

import com.example.data.league.datasource.remote.LeagueService
import com.example.data.league.datasource.remote.RemoteLeagueDataSource
import javax.inject.Inject

class LeagueDataSourceFactory @Inject constructor(private val leagueService: LeagueService) {
    fun createRemoteFootballLeagueDataSource() =
        RemoteLeagueDataSource(leagueService)
}