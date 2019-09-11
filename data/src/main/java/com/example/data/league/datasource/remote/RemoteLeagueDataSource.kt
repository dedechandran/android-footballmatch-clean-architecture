package com.example.data.league.datasource.remote

import com.example.data.league.datasource.LeagueDataSource
import com.example.data.league.datasource.remote.response.LeagueDetailResponse
import com.example.data.league.datasource.remote.response.LeagueResponse
import com.example.data.league.datasource.remote.response.LeagueStandingsResponse
import io.reactivex.Flowable
import javax.inject.Inject

class RemoteLeagueDataSource @Inject constructor(private val leagueService: LeagueService) :
    LeagueDataSource {
    override fun getLeagueStandings(leagueId: String): Flowable<LeagueStandingsResponse> =
        leagueService.getLeagueStandings(leagueId)


    override fun getDetailLeague(leagueId: String): Flowable<LeagueDetailResponse> =
        leagueService.getDetailLeague(leagueId)

    override fun getAllLeague(): Flowable<LeagueResponse> = leagueService.getAllLeague()
}