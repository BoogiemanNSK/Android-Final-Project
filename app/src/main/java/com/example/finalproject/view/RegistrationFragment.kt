package com.example.finalproject.view

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentRegistrationBinding
import kotlin.concurrent.fixedRateTimer

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_registration,
            container,
            false
        )

        binding.buttonCancelRegistration.setOnClickListener { findNavController().popBackStack() }
        binding.buttonSignup.setOnClickListener { onSignUp() }

        fixedRateTimer("logo_reg", false, 2 * 1000, 2 * 1000) {
            activity?.runOnUiThread {
                val animatedLogo = (binding.logo.drawable) as AnimatedVectorDrawable
                animatedLogo.start()
            }
        }

        return binding.root
    }

    private fun onSignUp() {

        val login = binding.editTextLogin.text.toString()
        val email = binding.editTextEmail.text.toString()
        val pass = binding.editTextPassword.text.toString()
        val passConfirm = binding.editTextPasswordConfirm.text.toString()

        if (pass != passConfirm) {
            return
        }

        //        todo: sign up here

        val action =
            RegistrationFragmentDirections.actionFragmentRegistrationToFragmentLogin(email, pass)
        findNavController().navigate(action)
    }
}