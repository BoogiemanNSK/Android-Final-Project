package com.example.finalproject.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalproject.data.ChallengeRepository
import com.example.finalproject.data.model.Challenge
import com.example.finalproject.data.model.MyChallenge
import javax.inject.Inject

class TakenChallengesViewModel
    @Inject constructor(application: Application, val repository: ChallengeRepository
) : AndroidViewModel(application) {
    private val _takenChallenges: MutableLiveData<List<MyChallenge>> = MutableLiveData()
    val takenChallenges: LiveData<List<MyChallenge>> get() = _takenChallenges

    init {
        _takenChallenges.postValue(
                repository.getMyTakenChallenges().value ?: emptyList())
    }
}