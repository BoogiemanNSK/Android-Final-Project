package com.example.finalproject.view

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.BuildConfig
import com.example.finalproject.R
import com.example.finalproject.data.AuthorizationService
import com.example.finalproject.data.requests.LoginRequest
import com.example.finalproject.data.requests.RegisterRequest
import com.example.finalproject.data.responses.TokenResponse
import com.example.finalproject.databinding.FragmentRegistrationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer

class RegistrationFragment : Fragment() {

    //@Inject
    //lateinit var authorizationService: AuthorizationService

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
            Toast.makeText(context, R.string.passwords_mismatch, Toast.LENGTH_SHORT).show()
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val authorizationService = retrofit.create(AuthorizationService::class.java)

        authorizationService.register(RegisterRequest(email, login, pass))
            .enqueue(object : Callback<TokenResponse> {

                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    Toast.makeText(context, R.string.register_error, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show()
                    val action =
                        RegistrationFragmentDirections.actionFragmentRegistrationToFragmentLogin(email, pass)
                    findNavController().navigate(action)
                }

            })
    }
}