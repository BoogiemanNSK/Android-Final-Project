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
import com.example.finalproject.BuildConfig
import com.example.finalproject.R
import com.example.finalproject.data.AuthorizationService
import com.example.finalproject.data.requests.LoginRequest
import com.example.finalproject.data.requests.RegisterRequest
import com.example.finalproject.data.responses.TokenResponse
import com.example.finalproject.databinding.FragmentLoginBinding
import com.example.finalproject.preferences.SharedPreferencesWrapper
import com.example.finalproject.viewmodels.LoginViewModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer

class LoginFragment : Fragment() {

    //@Inject
    //lateinit var vm: LoginViewModel

    //@Inject
    //lateinit var sharedPreferences: SharedPreferencesWrapper


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

        /*vm.loggedIn.observe(this.viewLifecycleOwner, { logged ->
            if (logged) {
                setLogined(true)
                val action = LoginFragmentDirections.actionFragmentLoginToFragmentTakenChallenges()
                findNavController().navigate(action)
            } else {
                Toast.makeText(context, R.string.login_error, Toast.LENGTH_SHORT).show()
            }
        })*/

        return binding.root
    }

    private fun onLogin() {
        /*vm.login(
            binding.editTextLogin.text.toString(),
            binding.editTextPassword.text.toString(),
            getString(R.string.token_key)
        )*/

        val okHttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
        }

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpBuilder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val authorizationService = retrofit.create(AuthorizationService::class.java)
        val sharedPreferences = SharedPreferencesWrapper(requireContext(), true)

        val email = binding.editTextLogin.text.toString()
        val pass = binding.editTextPassword.text.toString()

        authorizationService.login(LoginRequest(email, pass))
            .enqueue(object : Callback<TokenResponse> {

                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    Toast.makeText(context, R.string.login_error, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show()
                    setLogined(true)
                    sharedPreferences.set(getString(R.string.token_key), response.body()?.token.orEmpty())
                    val action = LoginFragmentDirections.actionFragmentLoginToFragmentTakenChallenges()
                    findNavController().navigate(action)
                }

            })
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