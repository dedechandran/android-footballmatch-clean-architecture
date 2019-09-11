package com.example.data.league.mapper

import com.example.data.league.datasource.remote.response.LeagueDetailResponse
import com.example.data.league.datasource.remote.response.LeagueResponse
import com.example.data.league.datasource.remote.response.LeagueStandingsResponse
import com.example.domain.entities.FootballLeagueDetailEntity
import com.example.domain.entities.FootballLeagueEntity
import com.example.domain.entities.FootballLeagueStandingsEntity
import javax.inject.Inject

class FootballLeagueMapper @Inject constructor() {
    fun transform(leagueResponse: LeagueResponse): List<FootballLeagueEntity> {
        val data = mutableListOf<FootballLeagueEntity>()
        leagueResponse.data.filter {
            it.leagueType == "Soccer"
        }.map {
            data.add(
                FootballLeagueEntity(
                    leagueFootballId = it.leagueId.toInt(),
                    leagueFootballName = it.leagueName
                )
            )
        }
        return data
    }

    fun transform(leagueDetailResponse: LeagueDetailResponse): FootballLeagueDetailEntity =
        FootballLeagueDetailEntity(
            leagueFootballName = leagueDetailResponse.data[0].leagueName,
            leagueFootballId = leagueDetailResponse.data[0].leagueId.toInt(),
            leagueFormedYear = leagueDetailResponse.data[0].leagueFormedYear.toInt(),
            leagueLogoUrl = leagueDetailResponse.data[0].leagueLogoUrl,
            leagueFbUrl = leagueDetailResponse.data[0].leagueFbUrl,
            leagueTwitterUrl = leagueDetailResponse.data[0].leagueTwitterUrl,
            leagueWebUrl = leagueDetailResponse.data[0].leagueWebUrl,
            leagueYtUrl = leagueDetailResponse.data[0].leagueYtUrl,
            leagueDescription = leagueDetailResponse.data[0].leagueDescription ?: ""
        )

    fun transform(leagueStandingsResponse: LeagueStandingsResponse): List<FootballLeagueStandingsEntity> {
        val data = mutableListOf<FootballLeagueStandingsEntity>()
        leagueStandingsResponse.data.map {
            data.add(
                FootballLeagueStandingsEntity(
                    teamId = it.teamId,
                    teamName = it.teamName,
                    teamDraw = it.teamDraw,
                    teamGoalAgainst = it.teamGoalAgainst,
                    teamGoalDifference = it.teamGoalDifference,
                    teamGoalFor = it.teamGoalFor,
                    teamLoss = it.teamLoss,
                    teamPlayed = it.teamPlayed,
                    teamTotal = it.teamTotal,
                    teamWin = it.teamWin
                )
            )
        }
        return data
    }
}