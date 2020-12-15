package com.example.finalproject.di

import android.content.Context
import com.example.finalproject.FinalApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideApplication() = FinalApplication.APPLICATION

    @Provides
    fun provideContext(): Context = FinalApplication.APPLICATION

}