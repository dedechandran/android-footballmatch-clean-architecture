package com.example.data.league.datasource.remote.response

import com.google.gson.annotations.SerializedName

class LeagueDetailResponse {
    @SerializedName("leagues")
    lateinit var data: List<LeagueData>

    data class LeagueData(
        @SerializedName("idLeague")
        val leagueId: String,
        @SerializedName("strLeague")
        val leagueName: String,
        @SerializedName("strSport")
        val leagueType: String,
        @SerializedName("intFormedYear")
        val leagueFormedYear: String,
        @SerializedName("strLogo")
        val leagueLogoUrl: String,
        @SerializedName("strWebsite")
        val leagueWebUrl: String,
        @SerializedName("strFacebook")
        val leagueFbUrl: String,
        @SerializedName("strTwitter")
        val leagueTwitterUrl: String,
        @SerializedName("strYoutube")
        val leagueYtUrl: String,
        @SerializedName("strDescriptionEN")
        val leagueDescription : String?
    )
}