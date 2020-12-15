package com.example.finalproject.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalproject.BuildConfig
import com.example.finalproject.R
import com.example.finalproject.data.ChallengeApi
import com.example.finalproject.data.requests.NewChallengeRequest
import com.example.finalproject.databinding.FragmentCreateChallengeBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

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

        binding.challengeCreate.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            val api = retrofit.create(ChallengeApi::class.java)

            val disposable = api.createNewChallenge(
                token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiMTIzNDUxMiIsInVpZCI6MiwiZXhwIjoxNjA4Mjc1NDk5fQ.5kOkYd4blAXSuZaoLCN_9oUbWBtQ0XVBLFW-vh1oSS0",
                body = NewChallengeRequest(
                    name = binding.challengeTitle.text.toString(),
                    description = binding.challengeDescription.text.toString(),
                    requirements = binding.editTextTextMultiLine2.text.toString()
                )
            ).enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                    Toast.makeText(context, "Challenge creation failed", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                    Toast.makeText(context, "Challenge created", Toast.LENGTH_SHORT).show()
                }
            })
        }

        return binding.root
    }


}