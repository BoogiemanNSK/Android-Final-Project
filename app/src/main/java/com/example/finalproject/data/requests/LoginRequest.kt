package com.example.finalproject.data.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest (
    @SerializedName("login")
    val login: String,
    @SerializedName("password")
    val password: String
)