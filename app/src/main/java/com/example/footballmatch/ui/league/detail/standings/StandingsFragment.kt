package com.example.footballmatch.ui.league.detail.standings


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.footballmatch.R
import com.example.footballmatch.base.BaseFragment
import javax.inject.Inject

class StandingsFragment @Inject constructor() : BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standings, container, false)
    }

}
