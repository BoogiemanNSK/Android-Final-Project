package com.example.finalproject.view

//import com.example.finalproject.data.ChallengeApi
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.finalproject.BuildConfig
import com.example.finalproject.R
import com.example.finalproject.data.ChallengeApi
import com.example.finalproject.databinding.FragmentLoginBinding
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LoginFragment : Fragment() {

    private val args: LoginFragmentArgs by navArgs()
    private lateinit var binding: FragmentLoginBinding

    companion object {
        fun newInstance() = CreatedChallengesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        setLogined(false)

        binding.buttonLogin.setOnClickListener { onLogin() }
        binding.buttonToSignUpFragment.setOnClickListener { onSignUp() }

        binding.editTextLogin.setText(args.login)
        binding.editTextPassword.setText(args.password)

//        // TODO Think of moving to another location
//        createService()

        return binding.root
    }

    private fun setLogined(flag: Boolean) {
        val sharedPref = activity?.getSharedPreferences("creds", Context.MODE_PRIVATE)
        if (sharedPref != null) {
            with(sharedPref.edit()) {
                putBoolean("_logined", flag)
                apply()
            }
        }
    }

    private fun onLogin() {
        // TODO Perform any required checks with backend

        setLogined(true)
        val action = LoginFragmentDirections.actionFragmentLoginToFragmentTakenChallenges()
        findNavController().navigate(action)
    }

    private fun onSignUp() {
        val action = LoginFragmentDirections.actionFragmentLoginToFragmentRegistration()
        findNavController().navigate(action)
    }

    private fun createService(): ChallengeApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ChallengeApi::class.java)
}