package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentCreatedChallengesBinding
import com.example.finalproject.view.adapters.ChallengeItemAdapter
import com.example.finalproject.viewmodels.CreatedChallengesViewModel
import kotlinx.android.synthetic.main.fragment_created_challenges.*
import javax.inject.Inject


class CreatedChallengesFragment : Fragment() {

    private lateinit var binding: FragmentCreatedChallengesBinding

    //@Inject
    //lateinit var viewModel:CreatedChallengesViewModel

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

        val challengeItemAdapter = ChallengeItemAdapter()
        binding.recyclerView.adapter = challengeItemAdapter

        //viewModel.createdChallenges.observe(this.viewLifecycleOwner, Observer { challenges ->
        //    challengeItemAdapter.setChallenges(challenges)
        //} )


        binding.buttonTakenChallenges.setOnClickListener { onTakenChallengesClick() }
        binding.buttonCreateNewChallenge.setOnClickListener { onCreateNewChallengeClick() }

        return binding.root
    }

    private fun onTakenChallengesClick() {
        val action =
            CreatedChallengesFragmentDirections.actionFragmentCreatedChallengesToFragmentTakenChallenges()
        findNavController().navigate(action)
    }

    private fun onCreateNewChallengeClick() {
        val action =
            CreatedChallengesFragmentDirections.actionFragmentCreatedChallengesToFragmentCreateChallenge()
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