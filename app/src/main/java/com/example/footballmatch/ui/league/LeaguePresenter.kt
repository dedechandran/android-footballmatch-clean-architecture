package com.example.footballmatch.ui.league

import com.example.domain.common.CustomSubscriber
import com.example.domain.entities.FootballLeagueEntity
import com.example.domain.interactor.FootballLeagueInteractor
import javax.inject.Inject

class LeaguePresenter @Inject constructor(private val footballLeagueInteractor: FootballLeagueInteractor) :
    LeagueContract.Presenter {
    private var leagueView: LeagueContract.View? = null

    override fun onAttach(view: LeagueContract.View) {
        leagueView = view
    }

    override fun onDetach() {
        leagueView = null
    }

    override fun loadLeagues() {
        footballLeagueInteractor.execute(LeagueSubscriber(), Unit)
    }

    override fun moveDetailActivity(leagueId: String) {
        leagueView?.moveDetailActivity(leagueId)
    }

    inner class LeagueSubscriber : CustomSubscriber<List<FootballLeagueEntity>>() {
        override fun onComplete() {
            leagueView?.showSnackbar("Success")
        }

        override fun onNext(data: List<FootballLeagueEntity>) {
            leagueView?.showLeagues(data)
        }

        override fun onError(t: Throwable?) {
            leagueView?.showSnackbar("Error")
        }
    }
}