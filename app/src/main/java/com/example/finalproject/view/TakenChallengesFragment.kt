package com.example.finalproject.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentTakenChallengesBinding
import com.example.finalproject.view.adapters.ChallengeItemAdapter
import com.example.finalproject.viewmodels.CreatedChallengesViewModel
import com.example.finalproject.viewmodels.TakenChallengesViewModel
import kotlinx.android.synthetic.main.fragment_created_challenges.*
import javax.inject.Inject

class TakenChallengesFragment : Fragment() {

    private lateinit var binding: FragmentTakenChallengesBinding

    @Inject
    lateinit var viewModel: TakenChallengesViewModel

    companion object {
        fun newInstance() = CreatedChallengesFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        checkIfLogined()

        binding.buttonCreatedChallenges.setOnClickListener { onCreatedChallengesClick() }
        val challengeItemAdapter = ChallengeItemAdapter()
        recyclerView.adapter = challengeItemAdapter

        viewModel.takenChallenges.observe(this.viewLifecycleOwner, Observer { challenges ->
            challengeItemAdapter.setMyChallenges(challenges)
        } )

        return binding.root
    }

    private fun checkIfLogined() {
        val sharedPref = activity?.getSharedPreferences("creds", Context.MODE_PRIVATE)
        val alreadyLogined = sharedPref?.getBoolean("_logined", false) ?: false
        if (!alreadyLogined) {
            val action =
                TakenChallengesFragmentDirections.actionFragmentTakenChallengesToFragmentLogin()
            findNavController().navigate(action)
        }
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