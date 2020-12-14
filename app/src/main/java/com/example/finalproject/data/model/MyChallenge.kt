package com.example.finalproject.data.model

import com.google.gson.annotations.SerializedName

data class MyChallenge(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("challenge")
    val challenge: Challenge,
    @SerializedName("name")
    val name: String,
    @SerializedName("comment")
    val comment: String,
    /*@SerializedName("start_date")
    val start_date: Date,*/ // TODO Check this one
    @SerializedName("final_comment")
    val final_comment: String,
    @SerializedName("photo")
    val photo: Array<Byte>, // TODO Try something different here maybe??
    @SerializedName("status")
    val status: String
)
