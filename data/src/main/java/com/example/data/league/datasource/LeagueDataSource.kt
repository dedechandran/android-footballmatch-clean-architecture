package com.example.data.league.datasource

import com.example.data.league.datasource.remote.response.LeagueDetailResponse
import com.example.data.league.datasource.remote.response.LeagueResponse
import com.example.data.league.datasource.remote.response.LeagueStandingsResponse
import io.reactivex.Flowable

interface LeagueDataSource {
    fun getAllLeague() : Flowable<LeagueResponse>
    fun getDetailLeague(leagueId : String) : Flowable<LeagueDetailResponse>
    fun getLeagueStandings(leagueId: String) : Flowable<LeagueStandingsResponse>
}