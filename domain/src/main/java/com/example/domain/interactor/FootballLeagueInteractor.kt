package com.example.domain.interactor

import com.example.domain.PostExecutionThread
import com.example.domain.common.BaseFlowable
import com.example.domain.entities.FootballLeagueEntity
import com.example.domain.repository.LeagueRepository
import io.reactivex.Flowable
import javax.inject.Inject

class FootballLeagueInteractor @Inject constructor(
    private val leagueRepository: LeagueRepository,
    postExecutionThread: PostExecutionThread
) : BaseFlowable<List<FootballLeagueEntity>, Unit>(postExecutionThread) {
    override fun build(params: Unit): Flowable<List<FootballLeagueEntity>> =
        leagueRepository.getAllFootballLeague()
}