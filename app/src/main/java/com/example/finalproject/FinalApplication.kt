package com.example.finalproject

import android.app.Application
import com.example.finalproject.di.ApplicationComponent
import com.example.finalproject.di.DaggerApplicationComponent

class FinalApplication : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        APPLICATION = this
        appComponent = DaggerApplicationComponent.builder().build()
    }

    companion object {
        lateinit var APPLICATION: Application
    }
}
