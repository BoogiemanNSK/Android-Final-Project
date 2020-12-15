package com.example.finalproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.finalproject.BuildConfig
import com.example.finalproject.R
import com.example.finalproject.data.ChallengeApi
import com.example.finalproject.data.ChallengeRepository
import com.example.finalproject.data.interceptors.TokenInterceptor
import com.example.finalproject.databinding.FragmentSearchBinding
import com.example.finalproject.view.adapters.ChallengeItemAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.view.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment() {

    private lateinit var challengeRepository: ChallengeRepository
    private lateinit var binding: FragmentSearchBinding
    //@Inject
    //lateinit var viewModel: ChallengesViewModel

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

        //val challengeItemAdapter = ChallengeItemAdapter()

        // viewModel.allChallenges.observe(this.viewLifecycleOwner, Observer { challenges ->
        //    challengeItemAdapter.setChallenges(challenges)
        // } )

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val api = retrofit.create(ChallengeApi::class.java)

        val disposable = api.getChallenges("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiMTIzNDUxMiIsInVpZCI6MiwiZXhwIjoxNjA4Mjc1NDk5fQ.5kOkYd4blAXSuZaoLCN_9oUbWBtQ0XVBLFW-vh1oSS0")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result ->
                    val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, result.challengesArray)
                    binding.recyclerViewSearch.adapter = adapter
                },
                { error ->
                    Toast.makeText(context, "Request failed", Toast.LENGTH_SHORT).show()
                }
            )

        //binding.root.search_edit_text.doAfterTextChanged {
        //    val challenges = challengeRepository.getAllChallenges(
        //        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiMTIzNDUxMiIsInVpZCI6MiwiZXhwIjoxNjA4Mjc1NDk5fQ.5kOkYd4blAXSuZaoLCN_9oUbWBtQ0XVBLFW-vh1oSS0"
        //    ).value!!
        //    challengeItemAdapter.setChallenges(challenges)
        //}

        return binding.root
    }

}