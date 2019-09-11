package com.example.domain.interactor

import com.example.domain.PostExecutionThread
import com.example.domain.common.BaseFlowable
import com.example.domain.entities.FootballLeagueDetailEntity
import com.example.domain.repository.LeagueRepository
import io.reactivex.Flowable
import javax.inject.Inject

class FootballLeagueDetailInteractor @Inject constructor(
    private val leagueRepository: LeagueRepository,
    postExecutionThread: PostExecutionThread
) : BaseFlowable<FootballLeagueDetailEntity, String>(postExecutionThread) {
    override fun build(params: String): Flowable<FootballLeagueDetailEntity> =
        leagueRepository.getDetailFootballLeague(params)
}