package com.example.footballmatch.ui.league.detail

import com.example.domain.common.CustomSubscriber
import com.example.domain.entities.FootballLeagueDetailEntity
import com.example.domain.interactor.FootballLeagueDetailInteractor
import javax.inject.Inject

class LeagueDetailPresenter @Inject constructor(private val footballLeagueDetailInteractor: FootballLeagueDetailInteractor) :
    LeagueDetailContract.Presenter {
    override fun loadLeagueDetail() {
        val leagueId = leagueDetailView?.getLeagueId()
        footballLeagueDetailInteractor.execute(FootballLeagueDetailSubscriber(), leagueId!!)
    }

    private var leagueDetailView: LeagueDetailContract.View? = null
    override fun onAttach(view: LeagueDetailContract.View) {
        leagueDetailView = view
    }

    override fun onDetach() {
        leagueDetailView = null
    }

    inner class FootballLeagueDetailSubscriber : CustomSubscriber<FootballLeagueDetailEntity>() {
        override fun onComplete() {
            leagueDetailView?.showSnackbar("SUCCESS")
        }

        override fun onNext(data: FootballLeagueDetailEntity) {
            leagueDetailView?.showLeagueDetail(data)
        }

        override fun onError(t: Throwable?) {
            leagueDetailView?.showSnackbar("ERROR")
        }
    }
}