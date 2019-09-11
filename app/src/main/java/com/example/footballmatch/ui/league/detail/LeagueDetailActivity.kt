package com.example.footballmatch.ui.league.detail


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.domain.entities.FootballLeagueDetailEntity
import com.example.footballmatch.R
import com.example.footballmatch.base.BaseActivity
import com.example.footballmatch.di.GlideApp
import com.example.footballmatch.fixtures.EXTRA_LEAGUE_ID
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.tabs.TabLayout
import javax.inject.Inject

class LeagueDetailActivity : BaseActivity(), LeagueDetailContract.View {
    @Inject
    lateinit var presenter: LeagueDetailContract.Presenter

    @Inject
    lateinit var pagerAdapter: LeagueDetailPagerAdapter

    override fun getLeagueId() = intent.getStringExtra(EXTRA_LEAGUE_ID)

    override fun showLeagueDetail(footballLeagueDetailEntity: FootballLeagueDetailEntity) {
        Log.d("DETAIL ACTIVITY",footballLeagueDetailEntity.toString())
        GlideApp.with(this)
            .load(footballLeagueDetailEntity.leagueLogoUrl)
            .into(leagueDetailLogo)
        leagueDetailName.text = footballLeagueDetailEntity.leagueFootballName
        leagueDetailDescription.text = footballLeagueDetailEntity.leagueDescription
        leagueDetailWebUrl.text = footballLeagueDetailEntity.leagueWebUrl
        leagueDetailFbUrl.text = footballLeagueDetailEntity.leagueFbUrl
        leagueDetailTwitterUrl.text = footballLeagueDetailEntity.leagueTwitterUrl
        leagueDetailYtUrl.text = footballLeagueDetailEntity.leagueYtUrl
    }

    override fun showSnackbar(message: String) {

    }

    private val leagueDetailTab by bindView<TabLayout>(R.id.league_detail_tab)
    private val leagueDetailViewPager by bindView<ViewPager>(R.id.league_detail_view_pager)
    private val leagueDetailToolbar by bindView<Toolbar>(R.id.league_detail_toolbar)
    private val leagueDetailCollapsingToolbar by bindView<CollapsingToolbarLayout>(R.id.league_detail_collapsingTollbar)
    private val leagueDetailLogo by bindView<ImageView>(R.id.img_league_detail)
    private val leagueDetailName by bindView<TextView>(R.id.tv_league_detail_name)
    private val leagueDetailDescription by bindView<TextView>(R.id.tv_league_detail_description)
    private val leagueDetailWebUrl by bindView<TextView>(R.id.tv_league_detail_url)
    private val leagueDetailFbUrl by bindView<TextView>(R.id.tv_league_detail_facebook)
    private val leagueDetailTwitterUrl by bindView<TextView>(R.id.tv_league_detail_twitter)
    private val leagueDetailYtUrl by bindView<TextView>(R.id.tv_league_detail_youtube)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league_detail)
        setSupportActionBar(leagueDetailToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        leagueDetailViewPager.adapter = pagerAdapter
        leagueDetailTab.setupWithViewPager(leagueDetailViewPager)
        presenter.onAttach(this)
        presenter.loadLeagueDetail()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.league_detail_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
