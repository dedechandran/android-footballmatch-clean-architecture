package com.example.domain.interactor

import com.example.domain.PostExecutionThread
import com.example.domain.common.BaseFlowable
import com.example.domain.entities.FootballLeagueStandingsEntity
import com.example.domain.repository.LeagueRepository
import io.reactivex.Flowable
import javax.inject.Inject

class FootballLeagueStandingsInteractor @Inject constructor(
    private val leagueRepository: LeagueRepository,
    val postExecutionThread: PostExecutionThread
) : BaseFlowable<List<FootballLeagueStandingsEntity>, String>(postExecutionThread) {
    override fun build(params: String): Flowable<List<FootballLeagueStandingsEntity>> =
        leagueRepository.getStandings(params)


}