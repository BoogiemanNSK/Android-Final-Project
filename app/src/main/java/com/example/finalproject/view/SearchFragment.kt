package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentSearchBinding
import com.example.finalproject.view.adapters.ChallengeItemAdapter
import com.example.finalproject.viewmodels.ChallengesViewModel
import kotlinx.android.synthetic.main.fragment_created_challenges.*
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    @Inject
    lateinit var viewModel: ChallengesViewModel

    companion object {
        fun newInstance() = CreatedChallengesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_search,
            container,
            false
        )

        val challengeItemAdapter = ChallengeItemAdapter()
        binding.recyclerViewSearch.adapter = challengeItemAdapter

        viewModel.allChallenges.observe(this.viewLifecycleOwner, Observer { challenges ->
            challengeItemAdapter.setChallenges(challenges)
        } )


        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Add OnTextChange listener to textBox
//        search_edit_text.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {}
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                // TODO Update list of challenges from backend
//                // TODO Add onClickListener on each challenge -> toViewChallengeActivity
//            }
//        })
//    }
//
//    private fun toViewChallengeActivity(challengeId: Int) {
//        val activity = (requireActivity() as MainActivity)
//        activity.viewChallengeInfo(challengeId)
//    }

}