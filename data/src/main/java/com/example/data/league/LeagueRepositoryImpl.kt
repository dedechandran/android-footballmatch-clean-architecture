package com.example.data.league

import com.example.data.league.mapper.FootballLeagueMapper
import com.example.domain.entities.FootballLeagueDetailEntity
import com.example.domain.entities.FootballLeagueEntity
import com.example.domain.entities.FootballLeagueStandingsEntity
import com.example.domain.repository.LeagueRepository
import io.reactivex.Flowable
import javax.inject.Inject

class LeagueRepositoryImpl @Inject constructor(
    private val leagueDataSourceFactory: LeagueDataSourceFactory,
    private val footballLeagueMapper: FootballLeagueMapper
) : LeagueRepository {
    override fun getStandings(leagueId: String): Flowable<List<FootballLeagueStandingsEntity>> {
        val remoteFootballLeagueDataStore = leagueDataSourceFactory.createRemoteFootballLeagueDataSource()
        return remoteFootballLeagueDataStore.getLeagueStandings(leagueId).map { it }.map(footballLeagueMapper::transform)
    }

    override fun getDetailFootballLeague(leagueId: String): Flowable<FootballLeagueDetailEntity> {
        val remoteFootballLeagueDataStore = leagueDataSourceFactory.createRemoteFootballLeagueDataSource()
        return remoteFootballLeagueDataStore.getDetailLeague(leagueId).map { it }.map(footballLeagueMapper::transform)
    }

    override fun getAllFootballLeague(): Flowable<List<FootballLeagueEntity>> {
        val remoteFootballLeagueDataStore = leagueDataSourceFactory.createRemoteFootballLeagueDataSource()
        return remoteFootballLeagueDataStore.getAllLeague().map { it }.map(footballLeagueMapper::transform)
    }
}