package com.example.finalproject.data

import com.example.finalproject.data.responses.ChallengesResponse
import io.reactivex.Single
import retrofit2.http.*

interface ChallengeApi {

    @GET("challenges")
    fun getChallenges(): Single<ChallengesResponse>

    // TODO Fill with more requests

}