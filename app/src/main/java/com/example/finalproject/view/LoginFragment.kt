package com.example.finalproject.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.BuildConfig
import com.example.finalproject.MainActivity
import com.example.finalproject.R
import com.example.finalproject.data.ChallengeApi
//import com.example.finalproject.data.ChallengeApi
import com.example.finalproject.databinding.FragmentLoginBinding
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    companion object {
        fun newInstance() = CreatedChallengesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("trtr 2", findNavController().currentBackStackEntry?.destination?.toString() ?: "")
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.loginButton.setOnClickListener { onLogin() }
        binding.signUpButton.setOnClickListener { onSignUp() }
        binding.googleOauth.setOnClickListener { onGoogleLogin() }
        binding.facebookOauth.setOnClickListener { onFacebookLogin() }
        binding.twitterOauth.setOnClickListener { onTwitterLogin() }

//        // TODO Think of moving to another location
//        createService()

        return binding.root
    }

    private fun onLogin() {
        // TODO Perform any required checks with backend

        val sharedPref = activity?.getSharedPreferences("creds", Context.MODE_PRIVATE)
        if (sharedPref != null) {
            with(sharedPref.edit()) {
                putBoolean("_logined", true)
                apply()
            }
        }
        val action = LoginFragmentDirections.actionFragmentLoginToFragmentTakenChallenges()
        findNavController().navigate(action)
    }

    private fun onSignUp() {
        // TODO To be implemented
    }

    private fun onGoogleLogin() {
        // TODO To be implemented
    }

    private fun onFacebookLogin() {
        // TODO To be implemented
    }

    private fun onTwitterLogin() {
        // TODO To be implemented
    }

    // TODO Maybe move this somewhere else
    private fun createService(): ChallengeApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ChallengeApi::class.java)
}