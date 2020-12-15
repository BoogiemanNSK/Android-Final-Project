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
    fun getMyChallenges(@Header("Authorization") token: String): Single<MyChallengesResponse>

    @GET("challenge/created")
    fun getCreatedChallenges(@Header("Authorization") token: String): Single<ChallengesResponse>

    @POST("challenge/new")
    fun createNewChallenge(@Header("Authorization") token: String, @Body body: NewChallengeRequest): Call<okhttp3.ResponseBody>

    @GET("challenge/take")
    fun takeChallenge(@Header("Authorization") token: String, @Query("challenge") challengeId: Int): Call<okhttp3.ResponseBody>

    @GET("challenge/complete")
    fun completeChallenge(@Header("Authorization") token: String, @Query("challenge") challengeId: Int): Call<okhttp3.ResponseBody>

    @GET("challenge/reject")
    fun rejectChallenge(@Header("Authorization") token: String, @Query("challenge") challengeId: Int): Call<okhttp3.ResponseBody>

}