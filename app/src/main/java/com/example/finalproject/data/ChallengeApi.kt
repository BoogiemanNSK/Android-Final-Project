package com.example.finalproject.data

import com.example.finalproject.data.requests.NewChallengeRequest
import com.example.finalproject.data.responses.ChallengesResponse
import com.example.finalproject.data.responses.MyChallengesResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface ChallengeApi {

    @GET("challenge/all")
    fun getChallenges(@Header("Authorization") token: String): Single<ChallengesResponse>

    @GET("challenge/my")
    fun getMyChallenges(): Single<MyChallengesResponse>

    @GET("challenge/created")
    fun getCreatedChallenges(): Single<ChallengesResponse>

    @POST("challenge/new")
    fun createNewChallenge(@Body body: NewChallengeRequest): Call<okhttp3.Response>

    @GET("challenge/take")
    fun takeChallenge(@Query("challenge") challengeId: Int): Call<okhttp3.Response>

    @GET("challenge/complete")
    fun completeChallenge(@Query("challenge") challengeId: Int): Call<okhttp3.Response>

    @GET("challenge/reject")
    fun rejectChallenge(@Query("challenge") challengeId: Int): Call<okhttp3.Response>

}