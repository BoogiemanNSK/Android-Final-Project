package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.finalproject.BuildConfig
import com.example.finalproject.R
import com.example.finalproject.data.ChallengeApi
import com.example.finalproject.databinding.FragmentCreatedChallengesBinding
import com.example.finalproject.view.adapters.ChallengeItemAdapter
import com.example.finalproject.viewmodels.CreatedChallengesViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_created_challenges.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val api = retrofit.create(ChallengeApi::class.java)

/*        val disposable = api.getCreatedChallenges("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiMTIzNDUxMiIsInVpZCI6MiwiZXhwIjoxNjA4Mjc1NDk5fQ.5kOkYd4blAXSuZaoLCN_9oUbWBtQ0XVBLFW-vh1oSS0")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result ->
                    challengeItemAdapter.setChallenges(result.challengesArray.toList())
                },
                { error ->
                    Toast.makeText(context, "Request failed", Toast.LENGTH_SHORT).show()
                }
            )*/

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