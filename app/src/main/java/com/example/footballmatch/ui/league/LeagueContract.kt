package com.example.footballmatch.ui.league

import com.example.domain.entities.FootballLeagueEntity
import com.example.footballmatch.base.BaseContract

interface LeagueContract {
    interface View : BaseContract.View{
        fun showLeagues(leagues : List<FootballLeagueEntity>)
        fun moveDetailActivity(leagueId: String)
    }
    interface Presenter : BaseContract.Presenter<View>{
        fun loadLeagues()
        fun moveDetailActivity(leagueId : String)
    }
}