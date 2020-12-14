package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentTakenChallengesBinding

class TakenChallengesFragment : Fragment() {

    private lateinit var binding: FragmentTakenChallengesBinding

    companion object {
        fun newInstance() = CreatedChallengesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_taken_challenges,
            container,
            false
        )

        binding.buttonCreatedChallenges.setOnClickListener { onCreatedChallengesClick() }

        return binding.root
    }

    private fun onCreatedChallengesClick() {
        val action =
            TakenChallengesFragmentDirections.actionFragmentTakenChallengesToFragmentCreatedChallenges()
        findNavController().navigate(action)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        to_created_challenges.setOnClickListener { toAdjacentFragment() }
//        // TODO Fill taken_challenges_list with data from backend
//        // TODO Add onClickListener on each challenge -> toViewChallengeActivity
//    }
//
//    private fun toAdjacentFragment() {
//        val activity = (requireActivity() as MainActivity)
//        activity.onChallengesClick()
//    }
//
//    private fun toViewChallengeActivity(challengeId: Int) {
//        val activity = (requireActivity() as MainActivity)
//        activity.viewChallengeInfo(challengeId)
//    }

}