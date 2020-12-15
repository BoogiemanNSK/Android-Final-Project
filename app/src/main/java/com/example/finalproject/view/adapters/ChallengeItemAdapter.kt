package com.example.finalproject.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.model.Challenge
import com.example.finalproject.data.model.MyChallenge

class ChallengeItemAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listOfChallenges = listOf<Challenge>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ChallengeViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.challenge_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int = listOfChallenges.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val challengeViewHolder = viewHolder as ChallengeViewHolder
        challengeViewHolder.bindView(listOfChallenges[position])
    }

    fun setChallenges(list: List<Challenge>){
        this.listOfChallenges = list
        notifyDataSetChanged()
    }
    fun setMyChallenges(list: List<MyChallenge>){
        this.listOfChallenges = list.map { c -> c.challenge }
        notifyDataSetChanged()
    }

}