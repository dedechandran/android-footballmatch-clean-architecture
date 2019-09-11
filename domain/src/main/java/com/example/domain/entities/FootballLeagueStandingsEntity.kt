package com.example.domain.entities

data class FootballLeagueStandingsEntity(
    val teamName: String,
    val teamId: String,
    val teamPlayed: String,
    val teamGoalFor: String,
    val teamGoalAgainst: String,
    val teamGoalDifference: String,
    val teamWin: String,
    val teamDraw: String,
    val teamLoss: String,
    val teamTotal: String
)