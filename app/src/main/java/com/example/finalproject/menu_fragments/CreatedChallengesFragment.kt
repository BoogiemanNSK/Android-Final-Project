package com.example.finalproject.menu_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.MainActivity
import com.example.finalproject.R
import kotlinx.android.synthetic.main.created_challenges_fragment.*

class CreatedChallengesFragment : Fragment() {

    companion object {
        fun newInstance() = CreatedChallengesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.created_challenges_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        to_taken_challenges.setOnClickListener { toAdjacentFragment() }
        create_new_challenge.setOnClickListener { toCreateNewChallengeActivity() }
        // TODO Fill created_challenges_list with data from backend
        // TODO Add onClickListener on each challenge -> toViewChallengeActivity
    }

    private fun toAdjacentFragment() {
        val activity = (requireActivity() as MainActivity)
        activity.onTakenClick()
    }

    private fun toCreateNewChallengeActivity() {
        val activity = (requireActivity() as MainActivity)
        activity.createNewChallenge()
    }

    private fun toViewChallengeActivity(challengeId: Int) {
        val activity = (requireActivity() as MainActivity)
        activity.viewChallengeInfo(challengeId)
    }

}