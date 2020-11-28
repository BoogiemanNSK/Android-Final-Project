package com.example.finalproject.menu_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.MainActivity
import com.example.finalproject.R
import kotlinx.android.synthetic.main.fragment_taken_challenges.*

class TakenChallengesFragment : Fragment() {

    companion object {
        fun newInstance() = TakenChallengesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_taken_challenges, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        to_created_challenges.setOnClickListener { toAdjacentFragment() }
        // TODO Fill taken_challenges_list with data from backend
        // TODO Add onClickListener on each challenge -> toViewChallengeActivity
    }

    private fun toAdjacentFragment() {
        val activity = (requireActivity() as MainActivity)
        activity.onChallengesClick()
    }

    private fun toViewChallengeActivity(challengeId: Int) {
        val activity = (requireActivity() as MainActivity)
        activity.viewChallengeInfo(challengeId)
    }

}