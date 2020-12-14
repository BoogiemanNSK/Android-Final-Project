package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentCreatedChallengesBinding


class CreatedChallengesFragment : Fragment() {

    private lateinit var binding: FragmentCreatedChallengesBinding

    companion object {
        fun newInstance() = CreatedChallengesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_created_challenges,
            container,
            false
        )

        binding.buttonTakenChallenges.setOnClickListener { onTakenChallengesClick() }

        return binding.root
    }

    private fun onTakenChallengesClick() {
        val action =
            CreatedChallengesFragmentDirections.actionFragmentCreatedChallengesToFragmentTakenChallenges()
        findNavController().navigate(action)
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        to_taken_challenges.setOnClickListener { toAdjacentFragment() }
//        create_new_challenge.setOnClickListener { toCreateNewChallengeActivity() }
//        // TODO Fill created_challenges_list with data from backend
//        // TODO Add onClickListener on each challenge -> toViewChallengeActivity
//    }
//
//    private fun toAdjacentFragment() {
//        val activity = (requireActivity() as MainActivity)
//        activity.onTakenClick()
//    }
//
//    private fun toCreateNewChallengeActivity() {
//        val activity = (requireActivity() as MainActivity)
//        activity.createNewChallenge()
//    }
//
//    private fun toViewChallengeActivity(challengeId: Int) {
//        val activity = (requireActivity() as MainActivity)
//        activity.viewChallengeInfo(challengeId)
//    }

}