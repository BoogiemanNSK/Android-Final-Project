package com.example.finalproject.di

import com.example.finalproject.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ApplicationModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)
}