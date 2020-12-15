package com.example.finalproject.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalproject.data.ChallengeRepository
import com.example.finalproject.data.model.Challenge
import javax.inject.Inject

class ChallengesViewModel
@Inject constructor(application: Application,
                                              val repository: ChallengeRepository
) : AndroidViewModel(application) {
    private val _allChallenges: MutableLiveData<List<Challenge>> = MutableLiveData()
    val allChallenges: LiveData<List<Challenge>> get() = _allChallenges
    init {
        _allChallenges.postValue(
                repository.getAllChallenges().value?: emptyList())
    }
}