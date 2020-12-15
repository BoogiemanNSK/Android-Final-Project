package com.example.finalproject.data

import com.example.finalproject.data.requests.LoginRequest
import com.example.finalproject.data.requests.RegisterRequest
import com.example.finalproject.data.responses.TokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationService {

    @POST("/login")
    fun login(@Body login: LoginRequest) : Call<TokenResponse>

    @POST("/register")
    fun register(@Body register: RegisterRequest) : Call<TokenResponse>

}