package com.example.finalproject.di

import android.app.Activity
import dagger.Component
import dagger.Module
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, ApplicationModule::class])
interface ApplicationComponent {

    fun inject(activity: Activity)
}