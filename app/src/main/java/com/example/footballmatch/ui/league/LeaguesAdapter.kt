package com.example.footballmatch.ui.league

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.FootballLeagueEntity
import com.example.footballmatch.R

class LeaguesAdapter (private val listener : (FootballLeagueEntity) -> Unit) : RecyclerView.Adapter<LeaguesAdapter.LeagueViewHolder>() {
    private val data = mutableListOf<FootballLeagueEntity>()

    fun setData(data : List<FootballLeagueEntity>){
        this.data.clear()
        this.data.addAll(data)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindView(data[position],listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LeagueViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.league_item,parent,false))

    override fun getItemCount() = data.size

    inner class LeagueViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val tvLeagueName by lazy {
            view.findViewById(R.id.tv_league_name) as TextView
        }

        fun bindView(item : FootballLeagueEntity,listener: (FootballLeagueEntity) -> Unit){
            tvLeagueName.text = item.leagueFootballName
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }
}
