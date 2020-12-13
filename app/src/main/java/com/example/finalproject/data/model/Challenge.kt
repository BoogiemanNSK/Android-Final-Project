package com.example.finalproject.data.model

import com.google.gson.annotations.SerializedName

data class Challenge(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("autho")
    val autho: Int,
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("taken")
    val taken: Int
    // TODO requirements
)
