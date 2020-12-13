package com.example.finalproject.data.responses

import com.example.finalproject.data.model.Challenge
import com.google.gson.annotations.SerializedName

data class ChallengesResponse(
    @SerializedName("challenges")
    val challengesArray: Array<Challenge>
)
