package com.example.data.league.datasource.remote.response

import com.google.gson.annotations.SerializedName

class LeagueStandingsResponse {
    @SerializedName("table")
    lateinit var data: List<StandingsData>
    data class StandingsData(
        @SerializedName("name")
        val teamName: String,
        @SerializedName("teamid")
        val teamId: String,
        @SerializedName("played")
        val teamPlayed: String,
        @SerializedName("goalsfor")
        val teamGoalFor: String,
        @SerializedName("goalsagainst")
        val teamGoalAgainst: String,
        @SerializedName("goalsdifference")
        val teamGoalDifference: String,
        @SerializedName("win")
        val teamWin: String,
        @SerializedName("draw")
        val teamDraw: String,
        @SerializedName("loss")
        val teamLoss: String,
        @SerializedName("total")
        val teamTotal: String
    )
}