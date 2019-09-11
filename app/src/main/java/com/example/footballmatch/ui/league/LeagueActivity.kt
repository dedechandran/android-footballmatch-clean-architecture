package com.example.footballmatch.ui.league

import android.content.Intent
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.FootballLeagueEntity
import com.example.footballmatch.R
import com.example.footballmatch.base.BaseActivity
import com.example.footballmatch.fixtures.EXTRA_LEAGUE_ID
import com.example.footballmatch.ui.league.detail.LeagueDetailActivity
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class LeagueActivity : BaseActivity(), LeagueContract.View {
    @Inject
    lateinit var presenter: LeagueContract.Presenter

    private lateinit var adapter: LeaguesAdapter

    private val mainLayout by bindView<ConstraintLayout>(R.id.main_layout)

    private val rvLeagues by bindView<RecyclerView>(R.id.rv_leagues)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
        presenter.loadLeagues()
        adapter = LeaguesAdapter { league ->
            presenter.moveDetailActivity(league.leagueFootballId.toString())
        }
        rvLeagues.layoutManager = GridLayoutManager(this, 2)
        rvLeagues.adapter = adapter
    }

    override fun showLeagues(leagues: List<FootballLeagueEntity>) {
        adapter.setData(leagues)
        adapter.notifyDataSetChanged()
    }

    override fun showSnackbar(message: String) {
        Snackbar.make(mainLayout, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun moveDetailActivity(leagueId: String) {
        val intent = Intent(this, LeagueDetailActivity::class.java)
        intent.putExtra(EXTRA_LEAGUE_ID, leagueId)
        startActivity(intent)
    }
}
