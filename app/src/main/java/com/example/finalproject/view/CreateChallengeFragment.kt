package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentCreateChallengeBinding

class CreateChallengeFragment : Fragment() {

    private lateinit var binding: FragmentCreateChallengeBinding

    companion object {
        fun newInstance() = CreatedChallengesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_create_challenge,
            container,
            false
        )

        binding.buttonCancelCreate.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}