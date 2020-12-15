package com.example.finalproject.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalproject.data.ChallengeRepository
import com.example.finalproject.data.model.Challenge
import java.lang.reflect.Constructor
import javax.inject.Inject
import javax.inject.Named

class CreatedChallengesViewModel
        @Inject constructor(application: Application,
        val repository: ChallengeRepository
) : AndroidViewModel(application) {
    private val _createdChallenges: MutableLiveData<List<Challenge>> = MutableLiveData()
    val createdChallenges:LiveData<List<Challenge>> get() = _createdChallenges
    init {
        /*_createdChallenges.postValue(
                repository.getMyCreatedChallenges().value?: emptyList())*/
    }
}