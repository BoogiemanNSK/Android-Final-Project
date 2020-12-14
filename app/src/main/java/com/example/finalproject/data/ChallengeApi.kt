package com.example.finalproject.data

import com.example.finalproject.BuildConfig
import com.example.finalproject.data.requests.NewChallengeRequest
import com.example.finalproject.data.responses.ChallengesResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ChallengeApi {

    @GET("challenge/all")
    fun getChallenges(): Single<ChallengesResponse>

    @GET("challenge/my")
    fun getMyChallenges(): Single<ChallengesResponse>

    @POST("challenge/new")
    fun createNewChallenge(@Body body: NewChallengeRequest): Call<okhttp3.Response>

    // TODO Fill with more requests

    companion object Factory {
        fun create(): ChallengeApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()

            return retrofit.create(ChallengeApi::class.java);
        }
    }

}