package com.example.domain.entities

data class FootballLeagueDetailEntity(
    val leagueFootballId: Number,
    val leagueFootballName: String,
    val leagueFormedYear : Number,
    val leagueLogoUrl : String,
    val leagueWebUrl : String,
    val leagueFbUrl : String,
    val leagueTwitterUrl : String,
    val leagueYtUrl : String,
    val leagueDescription : String
)