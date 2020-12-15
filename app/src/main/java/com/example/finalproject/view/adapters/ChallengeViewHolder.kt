package com.example.finalproject.view.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.data.model.Challenge
import kotlinx.android.synthetic.main.challenge_list_item.view.*;

class ChallengeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun bindView(challengeItem: Challenge){
        itemView.text_view_title.text = challengeItem.name
        itemView.text_view_description.text = challengeItem.description
        itemView.text_view_author.text = challengeItem.author.firstName
        itemView.text_view_tags.text = challengeItem.tags.joinToString(separator = ",")
    }
}