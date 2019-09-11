package com.example.data.league.datasource.remote.response

import com.google.gson.annotations.SerializedName

class LeagueResponse {
    @SerializedName("leagues")
    lateinit var data: List<LeagueData>

    data class LeagueData(
        @SerializedName("idLeague")
        val leagueId: String,
        @SerializedName("strLeague")
        val leagueName: String,
        @SerializedName("strSport")
        val leagueType: String
    )

}