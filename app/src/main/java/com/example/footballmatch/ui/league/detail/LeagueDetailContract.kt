package com.example.footballmatch.ui.league.detail

import com.example.domain.entities.FootballLeagueDetailEntity
import com.example.footballmatch.base.BaseContract

interface LeagueDetailContract {
    interface View : BaseContract.View{
        fun showLeagueDetail(footballLeagueDetailEntity: FootballLeagueDetailEntity)
        fun getLeagueId() : String?
    }
    interface Presenter : BaseContract.Presenter<View>{
        fun loadLeagueDetail()
    }
}