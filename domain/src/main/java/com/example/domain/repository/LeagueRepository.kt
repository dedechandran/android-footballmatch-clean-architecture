package com.example.domain.repository

import com.example.domain.entities.FootballLeagueDetailEntity
import com.example.domain.entities.FootballLeagueEntity
import com.example.domain.entities.FootballLeagueStandingsEntity
import io.reactivex.Flowable

interface LeagueRepository {
    fun getAllFootballLeague(): Flowable<List<FootballLeagueEntity>>
    fun getDetailFootballLeague(leagueId : String) : Flowable<FootballLeagueDetailEntity>
    fun getStandings(leagueId: String) : Flowable<List<FootballLeagueStandingsEntity>>
}