package com.example.finalproject.data.requests

import com.google.gson.annotations.SerializedName

data class NewChallengeRequest(
    @SerializedName("Title")
    val name: String,
    @SerializedName("Description")
    val description: String,
    @SerializedName("Requirements")
    val requirements: String
)
