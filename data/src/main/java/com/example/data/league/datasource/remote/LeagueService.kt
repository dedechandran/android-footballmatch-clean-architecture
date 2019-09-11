package com.example.data.league.datasource.remote

import com.example.data.league.datasource.remote.response.LeagueDetailResponse
import com.example.data.league.datasource.remote.response.LeagueResponse
import com.example.data.league.datasource.remote.response.LeagueStandingsResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface LeagueService {
    @GET("all_leagues.php")
    fun getAllLeague(): Flowable<LeagueResponse>

    @GET("lookupleague.php?")
    fun getDetailLeague(@Query("id") leagueId: String): Flowable<LeagueDetailResponse>

    @GET("lookuptable.php?")
    fun getLeagueStandings(@Query("l") leagueId: String) : Flowable<LeagueStandingsResponse>
}