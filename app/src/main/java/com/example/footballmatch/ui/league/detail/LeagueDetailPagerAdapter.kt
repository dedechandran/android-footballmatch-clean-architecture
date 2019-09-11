package com.example.footballmatch.ui.league.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.footballmatch.fixtures.LEAGUE_DETAIL_MATCHES_NAME
import com.example.footballmatch.fixtures.LEAGUE_DETAIL_STANDINGS_NAME
import com.example.footballmatch.fixtures.LEAGUE_DETAIL_TAB_COUNT
import com.example.footballmatch.fixtures.LEAGUE_DETAIL_TEAMS_NAME
import com.example.footballmatch.ui.league.detail.matches.MatchesFragment
import com.example.footballmatch.ui.league.detail.standings.StandingsFragment
import com.example.footballmatch.ui.league.detail.teams.TeamsFragment
import javax.inject.Inject

class LeagueDetailPagerAdapter @Inject constructor(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    @Inject
    lateinit var matchesFragment : MatchesFragment
    @Inject
    lateinit var standingsFragment : StandingsFragment
    @Inject
    lateinit var teamsFragment: TeamsFragment

    override fun getItem(position: Int) = when(position){
        0 -> matchesFragment
        1 -> standingsFragment
        2 -> teamsFragment
        else
            -> matchesFragment
    }

    override fun getCount() = LEAGUE_DETAIL_TAB_COUNT

    override fun getPageTitle(position: Int) = when(position){
        0 -> LEAGUE_DETAIL_MATCHES_NAME
        1 -> LEAGUE_DETAIL_STANDINGS_NAME
        2 -> LEAGUE_DETAIL_TEAMS_NAME
        else
            -> super.getPageTitle(position)
    }
}