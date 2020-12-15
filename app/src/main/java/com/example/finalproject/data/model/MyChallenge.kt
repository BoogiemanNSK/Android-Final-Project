package com.example.finalproject.data.model

import com.google.gson.annotations.SerializedName

data class MyChallenge(
    @SerializedName("Id")
    val id: Int?,
    @SerializedName("Challenge")
    val challenge: Challenge,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Comment")
    val comment: String,
    /*@SerializedName("start_date")
    val start_date: Date,*/ // TODO Check this one
    @SerializedName("Final_comment")
    val final_comment: String,
    @SerializedName("Photo")
    val photo: Array<Byte>, // TODO Try something different here maybe??
    @SerializedName("Status")
    val status: String
)
