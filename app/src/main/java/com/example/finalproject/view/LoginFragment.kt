package com.example.finalproject.view

import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentLoginBinding
import com.example.finalproject.viewmodels.LoginViewModel
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer

class LoginFragment : Fragment() {

    @Inject
    lateinit var vm: LoginViewModel

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

        fixedRateTimer("logo_login", false, 2 * 1000, 2 * 1000) {
            activity?.runOnUiThread {
                val animatedLogo = (binding.logo.drawable) as AnimatedVectorDrawable
                animatedLogo.start()
            }
        }

        vm.loggedIn.observe(this.viewLifecycleOwner, { logged ->
            if (logged) {
                setLogined(true)
                val action = LoginFragmentDirections.actionFragmentLoginToFragmentTakenChallenges()
                findNavController().navigate(action)
            } else {
                Toast.makeText(context, R.string.login_error, Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

    private fun onLogin() {
        vm.login(
            binding.editTextLogin.text.toString(),
            binding.editTextPassword.text.toString(),
            getString(R.string.token_key)
        )
    }

    private fun onSignUp() {
        val action = LoginFragmentDirections.actionFragmentLoginToFragmentRegistration()
        findNavController().navigate(action)
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

}