package com.example.finalproject.data.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        requestBuilder.addHeader("Authorization", "Bearer ")
        return chain.proceed(requestBuilder.build())
    }
}