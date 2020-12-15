package com.example.finalproject.di

import com.example.finalproject.BuildConfig
import com.example.finalproject.data.AuthorizationService
import com.example.finalproject.data.ChallengeApi
import com.example.finalproject.data.interceptors.TokenInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    @Named("logout")
    fun providesClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @Named("logged")
    fun providesLoggedClient(
        tokenInterceptor: TokenInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(tokenInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @Named("logout")
    fun providesRetrofit(@Named("logout") client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("logged")
    fun providesLoggedRetrofit(@Named("logged") client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesTokenService(@Named("logout") retrofit: Retrofit) : AuthorizationService {
        return retrofit.create(AuthorizationService::class.java)
    }

    @Provides
    @Singleton
    fun providesChallengeService(@Named("logged") retrofit: Retrofit) : ChallengeApi {
        return retrofit.create(ChallengeApi::class.java)
    }
}