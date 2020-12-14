package com.example.finalproject.data.model

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("firstName")
        val firstName: String,
        @SerializedName("email")
        val email: String
)
